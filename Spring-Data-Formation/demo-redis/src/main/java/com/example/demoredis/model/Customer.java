package com.example.demoredis.model;

import java.util.List;

import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import lombok.Data;

@RedisHash
@Data
public class Customer {

    private Long id;
    @Indexed
    private String externalId;
    private String name;
    private List<Account> accounts;
}