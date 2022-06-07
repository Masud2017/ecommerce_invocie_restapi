package com.ecommerce.invoice_restapi.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ecommerce.invoice_restapi.dao.UserRepository;
import com.ecommerce.invoice_restapi.model.User;

import net.bytebuddy.utility.RandomString;

@Service
public class AuthServiceImpl implements AuthService {
    private Logger logger = LoggerFactory.getLogger(AuthServiceImpl.class);
    @Autowired
    private UserDetailsService userDetailsUservice;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthenticationManager authenticationManager;
    // @Autowired
    // private JavaMailSender javaMailSender;

    @Override
    public UsernamePasswordAuthenticationToken authenticate(String username, String password) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password,new ArrayList<>());

        authenticationManager.authenticate(token);

        return null;
    }
    

    @Override
    public Integer unauthneticate() {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public com.ecommerce.invoice_restapi.model.User register(User user) {
        String verificationCode = RandomString.make(64);
        SimpleDateFormat dateFormatter = new SimpleDateFormat("E-MM-dd'T'HH:mm:ss.SSSZ-yyyy");
        
        Calendar currentTime = Calendar.getInstance();
        currentTime.add(Calendar.MINUTE, 5);
        String currentTimeString = dateFormatter.format(currentTime.getTime()).toString();

        String timeDateBase64 = Base64.getEncoder().encodeToString(currentTimeString.getBytes());
        verificationCode = verificationCode + "."+timeDateBase64;
        
        
        User ifAvail = this.userRepository.findByEmail(user.getEmail());
        if (ifAvail != null) {
            return ifAvail;
        }
        user.setPassword(this.passwordEncoder.encode(user.getPassword())); // encoding the password with bcrypt algorithm which is already declared in the bean
        user.setVerificationCode(verificationCode);
        user.setEnabled(false);
        

        logger.info("The verification link is : http://localhost:4445/verify?code="+user.getVerificationCode());
        
        this.userRepository.save(user);

      
        return user;
    }


    @Override
    public User verify(String code) {
        User user = this.userRepository.findByVerificationCode(code);
      
        if (user != null) {
            if (user.isEnabled()) {
                return user;
            } else {
                user.setEnabled(true);
            }
        }
        this.userRepository.save(user);
        return user;
    }

    @Deprecated
    protected boolean isVerificationCodeExpired(String code) {
        Date time = null;
        
        // at first need to check if the expiry time has gone
        String[] parts = code.split("\\.");
        String base64ToString = new String(Base64.getDecoder().decode(parts[1].getBytes()));

        // "Mon Jun 06 21:08:05 AKDT 2022"
        String timeString = base64ToString;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E-MM-dd'T'HH:mm:ss.SSSZ-yyyy");
        Date currentTimeToCompare = Calendar.getInstance().getTime();
        try {
            currentTimeToCompare = simpleDateFormat.parse(simpleDateFormat.format(currentTimeToCompare));
        } catch (ParseException e1) {
            e1.printStackTrace();
        }
        try {
            time = simpleDateFormat.parse(timeString);
            logger.info(time.toString()+"yo yo ");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long fiveMin = 1000 * 60 * 1; // converting 1 minute into milisecond for comparisn
        long elapsed = time.getTime() - currentTimeToCompare.getTime() ;
        
        if (elapsed < fiveMin) {
           return true;
        } else {

            return false;
        }
    }
    
}



   // MimeMessagePreparator prepare = new MimeMessagePreparator() {

        //     @Override
        //     public void prepare(MimeMessage mimeMessage) throws Exception {
        //         mimeMessage.setFrom(new InternetAddress("msmasud578@gmail.com"));
        //         mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(user.getEmail()));
        //         mimeMessage.setText("Dear "+user.getFirstName()+" "+user.getLastName()+"Please click this link and complete your verification"+"<a href = >");
                
        //     }
        // };

        // try {
        //     this.javaMailSender.send(prepare);
        // } catch (MailSendException e) {
        //     e.printStackTrace();
        // }