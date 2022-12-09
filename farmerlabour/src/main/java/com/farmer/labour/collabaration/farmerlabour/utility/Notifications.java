package com.farmer.labour.collabaration.farmerlabour.utility;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.farmer.labour.collabaration.farmerlabour.service.interfaces.UserServiceInf;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Notifications{

    @Autowired
    UserServiceInf userServiceInf;

    @Autowired
    private JavaMailSender emailSender;

    public String sendEmail(List<String> receipients,String body,String subject){


        Object[] receipientsObjs = receipients.toArray();
        SimpleMailMessage message = new SimpleMailMessage(); 
        message.setFrom("maldanna432@gmail.com");
        message.setTo((String[])receipientsObjs);; 
        message.setSubject(subject); 
        message.setText(body);
        emailSender.send(message);
        return "successfully email sent";
      
   
    }



}