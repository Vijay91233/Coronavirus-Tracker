package com.bus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class JmsConsumerService { // Updated class name to JmsConsumerServicae

    private final JavaMailSender javaMailSender;

    @Autowired
    public JmsConsumerService(JavaMailSender javaMailSender) { // Updated constructor name to JmsConsumerServicae
        this.javaMailSender = javaMailSender;
    }

    @JmsListener(destination = "email.queue") // Set the queue name where email messages are sent
    public void receiveEmailNotification(String message) {
        // Implement the email sending logic using JavaMail API
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo("harriettvijay@gmail.com"); // Replace with the actual recipient email address
            mailMessage.setSubject("New Movie Added");
            mailMessage.setText(message);

            javaMailSender.send(mailMessage);

            System.out.println("Email sent successfully!");
        } catch (MailException e) {
            System.out.println("Error sending email: " + e.getMessage());
        }
    }
}
