package com.zhitar.xml.example.service;

import com.zhitar.xml.example.entity.Currency;

import java.util.List;

public interface CurrencyService {

    Currency save(Currency currency);

    List<Currency> saveAll(List<Currency> currencies);

    List<Currency> getAll();
}
