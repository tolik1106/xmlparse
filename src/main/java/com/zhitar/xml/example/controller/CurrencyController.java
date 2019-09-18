package com.zhitar.xml.example.controller;

import com.zhitar.xml.example.entity.Exchange;
import com.zhitar.xml.example.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/currency")
public class CurrencyController {

    @Autowired
    private CurrencyService service;

    @PostMapping(consumes = {MediaType.APPLICATION_XML_VALUE})
    @ResponseStatus(HttpStatus.CREATED)
    public void handleXMLPostRequest(@RequestBody Exchange exchange) {
        Objects.requireNonNull(exchange);
        service.saveAll(exchange.getCurrencies());
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.OK)
    public Exchange getExchange() {
        Exchange exchange = new Exchange();
        exchange.setCurrencies(service.getAll());
        return exchange;
    }
}