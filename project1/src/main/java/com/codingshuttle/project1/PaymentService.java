package com.codingshuttle.project1;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class PaymentService {

    public void pay(){
        System.out.println("Paying...");
    }

    @PostConstruct
    public void afterInit() {
        System.out.println("Immediately after Bean is constructed..");
    }

    @PreDestroy
    public void beforeDestroy() {
        System.out.println("Immediately before a Bean is destroyed..");
    }
}
