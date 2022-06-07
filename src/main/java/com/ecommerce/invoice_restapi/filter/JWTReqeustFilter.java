package com.ecommerce.invoice_restapi.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.ecommerce.invoice_restapi.util.JWTUtil;

@Component
public class JWTReqeustFilter extends OncePerRequestFilter{
    private Logger logger = LoggerFactory.getLogger(JWTReqeustFilter.class);
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JWTUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        final RequestMatcher ignoredPaths = new AntPathRequestMatcher("/api/v1/authenticate");
        final RequestMatcher ignoredPaths2 = new AntPathRequestMatcher("/api/v1/register");

        if (ignoredPaths.matches(request)) { 
            filterChain.doFilter(request, response);
            return;
       }
       if (ignoredPaths2.matches(request)) { 
        filterChain.doFilter(request, response);
        return;
   }


        String jwtToken = request.getHeader("Authorization");
        String userName = null;
        String token = null;

        
        if (jwtToken.contains("Bearer")) {
            String[] splitedToken = jwtToken.split(" ");
            token = splitedToken[1];
            userName = this.jwtUtil.getUsernameFromToken(token);

            // now I have to parse the token for the user info
            
        } else {
            logger.warn("Token does not begin with beaerer");
        }


        if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(userName);

            if (this.jwtUtil.validateToken(token, userDetails)) {

				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());
				usernamePasswordAuthenticationToken
						.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
			
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}

        }
        
        filterChain.doFilter(request, response);
    }
    
}
