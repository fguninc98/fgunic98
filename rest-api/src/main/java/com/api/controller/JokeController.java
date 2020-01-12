package com.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.service.SubscriptionService;


import io.swagger.annotations.ApiOperation;

import com.api.model.UserSubsription;


@RestController
@RequestMapping("/joke")
public class JokeController {

    private SubscriptionService subscriptionService;

    public JokeController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }
    
    @ApiOperation(value = "Register subscription")
    @PostMapping("/joke")
    public ResponseEntity<UserSubsription> saveUserSubsription(@RequestBody UserSubsription userSubscription) {
        return new ResponseEntity<>(subscriptionService.add(userSubscription), HttpStatus.CREATED);
    }
}