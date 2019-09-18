package com.zhitar.xml.example.controller;

import com.zhitar.xml.example.entity.Exchange;
import com.zhitar.xml.example.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@RestController
@RequestMapping("/currency")
public class CurrencyController {

    private static final String EXCHANGE_URL = "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange";

    @Autowired
    private CurrencyService service;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.OK)
    public Exchange getExchange() {
        RestTemplate template = new RestTemplate();
        Exchange exchange = template.getForObject(EXCHANGE_URL, Exchange.class);
        service.saveAll(Objects.requireNonNull(exchange).getCurrencies());
        return exchange;
    }
}