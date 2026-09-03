package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo.service.INotificationService;

@Service
public class SmsService implements INotificationService {

    @Override
    public void Send(String message) {
        System.out.println("SMS: " + message);
    }

}
