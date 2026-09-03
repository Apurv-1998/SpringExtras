package com.example.demo.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    //@Qualifier("smsService")
    private final INotificationService notificationService;

    public OrderService(INotificationService notificationService) {
        this.notificationService = notificationService;
    }

}
