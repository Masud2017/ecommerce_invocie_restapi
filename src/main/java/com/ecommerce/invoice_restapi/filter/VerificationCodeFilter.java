// package com.ecommerce.invoice_restapi.filter;

// import java.io.DataOutputStream;
// import java.io.IOException;
// import java.io.OutputStream;
// import java.io.PrintWriter;
// import java.nio.charset.StandardCharsets;
// import java.text.ParseException;
// import java.text.SimpleDateFormat;
// import java.util.Base64;
// import java.util.Calendar;
// import java.util.Date;

// import javax.servlet.Filter;
// import javax.servlet.FilterChain;
// import javax.servlet.ServletException;
// import javax.servlet.ServletRequest;
// import javax.servlet.ServletResponse;
// import javax.servlet.annotation.WebFilter;
// import javax.servlet.http.HttpServletResponse;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.MediaType;

// import com.ecommerce.invoice_restapi.exception.VerificationCodeException;

// @WebFilter("/api/v1/verify")
// public class VerificationCodeFilter implements Filter {
//     private Logger logger = LoggerFactory.getLogger(VerificationCodeFilter.class);
//     public VerificationCodeFilter()throws VerificationCodeException {}

//     @Override
//     public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//             throws IOException, ServletException {

//         Date time = null;
        
//         // at first need to check if the expiry time has gone
//         String code = request.getParameter("code");
//         String[] parts = code.split("\\.");
//         String base64ToString = new String(Base64.getDecoder().decode(parts[1].getBytes()));

//         // "Mon Jun 06 21:08:05 AKDT 2022"
//         String timeString = base64ToString;
//         SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E-MM-dd'T'HH:mm:ss.SSSZ-yyyy");
//         Date currentTimeToCompare = Calendar.getInstance().getTime();
//         try {
//             currentTimeToCompare = simpleDateFormat.parse(simpleDateFormat.format(currentTimeToCompare));
//         } catch (ParseException e1) {
//             e1.printStackTrace();
//         }
//         try {
//             time = simpleDateFormat.parse(timeString);
//             logger.info(time.toString()+"yo yo ");
//         } catch (ParseException e) {
//             e.printStackTrace();
//         }
//         long fiveMin = 1000 * 60 * 1; // converting 1 minute into milisecond for comparisn
//         long elapsed = time.getTime() - currentTimeToCompare.getTime() ;
        
//         if (elapsed < fiveMin) {
//             logger.info("Time has expired ; "+elapsed);
//             OutputStream out = response.getOutputStream();
//             DataOutputStream dout = new DataOutputStream(out);
//             dout.writeUTF(new String("Token has expired".getBytes(),StandardCharsets.UTF_8));
//             throw new RuntimeException("Token is expired");
            
           
//         } else {
//             logger.info("Time is still relevent "+elapsed);

//         }
        
//         this.logger.info("Yo this is from the verification filter"+request.getParameter("code"));
//         chain.doFilter(request, response);
//     }
    
// }
