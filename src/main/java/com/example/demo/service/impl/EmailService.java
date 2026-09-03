package com.example.demo.service.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.demo.service.INotificationService;

@Service
@Primary
public class EmailService implements INotificationService {

    @Override
    public void Send(String message) {
        System.out.println("Email:" + message);
    }

}
