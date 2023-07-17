package com.bus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import javax.jms.Queue;


@Service
public class JmsPublisherService {

    @Autowired
    private JmsTemplate jmsTemplate;
    
    
      public void sendEmailNotification(String message) {
        jmsTemplate.convertAndSend("email.Queue", message);
    }
}
