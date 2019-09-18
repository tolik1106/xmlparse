package com.zhitar.xml.example.dao;

import com.zhitar.xml.example.entity.Currency;

import java.util.List;

public interface CurrencyDao {

    Currency save(Currency currency);

    List<Currency> saveAll(List<Currency> currencies);

    List<Currency> getAll();
}
