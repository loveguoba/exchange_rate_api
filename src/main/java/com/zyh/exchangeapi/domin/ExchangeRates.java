package com.zyh.exchangeapi.domin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class ExchangeRates implements Serializable {

    private float EUR;
    private float CNY;
    private float DKK;
    private float GBP;
    private float SEK;
    private float USD;
    private float TWD;
    private float HKD;


}
