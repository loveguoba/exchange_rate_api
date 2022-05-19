package com.zyh.exchangeapi.domin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.Date;
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@RedisHash("ExchangeResult")
public class ExchangeResult implements Serializable {

    private String base;
    private Date date;
    private ExchangeRates rates;

}
