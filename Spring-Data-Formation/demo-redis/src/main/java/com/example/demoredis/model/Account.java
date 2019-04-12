package com.example.demoredis.model;

import org.springframework.data.redis.core.index.Indexed;

import lombok.Data;

@Data
public class Account {

    @Indexed
    private Long id;
    private String number;
    private Integer balance;
}