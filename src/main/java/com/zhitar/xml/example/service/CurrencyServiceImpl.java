package com.zhitar.xml.example.service;

import com.zhitar.xml.example.dao.CurrencyDao;
import com.zhitar.xml.example.entity.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class CurrencyServiceImpl implements CurrencyService {

    private CurrencyDao currencyDao;

    @Autowired
    public CurrencyServiceImpl(CurrencyDao currencyDao) {
        this.currencyDao = currencyDao;
    }

    @Override
    public Currency save(Currency currency) {
        return currencyDao.save(currency);
    }

    @Override
    public List<Currency> saveAll(List<Currency> currencies) {
        if (currencies == null || currencies.isEmpty()) {
            throw new RuntimeException("Empty currencies");
        }
        return currencyDao.saveAll(currencies);
    }

    @Override
    public List<Currency> getAll() {
        return currencyDao.getAll();
    }
}