package com.zyh.exchangeapi.service;

import com.zyh.exchangeapi.domin.ExchangeResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Service
public class ApiLayerExchangeReader {

    private static final Logger log = LoggerFactory.getLogger(ApiLayerExchangeReader.class);

    @Autowired
    private RestTemplate restTemplate;

    public ExchangeResult read () throws Exception{

        HttpHeaders headers = new HttpHeaders();
        headers.set("apikey", "OsHQ8HmAr2G226fcKe4z2vKcEZJz746x");
        headers.set("User-Agent", "PostmanRuntime/7.28.4");

        HttpEntity<String> entity = new HttpEntity<>("body", headers);

        try {
            ResponseEntity<ExchangeResult> exchange = restTemplate.exchange("https://api.apilayer.com/exchangerates_data/latest", HttpMethod.GET, entity, ExchangeResult.class);
            ExchangeResult body = exchange.getBody();
            return body;
        }catch (Throwable e){
            throw new Exception("Cannot read exchange from apilayer: " + e.getMessage());
        }
    }
}
