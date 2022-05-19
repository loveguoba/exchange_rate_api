package com.zyh.exchangeapi.controller;

import com.zyh.exchangeapi.domin.ExchangeResult;
import com.zyh.exchangeapi.service.ApiLayerExchangeReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class ExchangeController {

    private static final Logger log = LoggerFactory.getLogger(ExchangeController.class);

    @Autowired
    private ApiLayerExchangeReader apiLayerExchangeReader;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @GetMapping("/exchange")
    public ExchangeResult exchangeResult() {

        Object exchangeResult = redisTemplate.opsForValue().get("exchangeResult");
        if (exchangeResult == null) {
            ExchangeResult read = null;
            try {
                read = apiLayerExchangeReader.read();
            } catch (Exception e) {
                e.printStackTrace();
            }
            redisTemplate.opsForValue().set("exchangeResult", read, 30, TimeUnit.SECONDS);
            return read;

        }
        return (ExchangeResult) exchangeResult;

    }
}
