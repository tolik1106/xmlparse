package com.zhitar.xml.example.dao;

import com.zhitar.xml.example.entity.Currency;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository
public class CurrencyDaoImpl implements CurrencyDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Currency save(Currency currency) {
        entityManager.persist(currency);
        return currency;
    }

    @Override
    public List<Currency> saveAll(List<Currency> currencies) {
        for (Currency currency : currencies) {
            save(currency);
        }
        return currencies;
    }

    @Override
    public List<Currency> getAll() {
        CriteriaQuery<Currency> criteria = entityManager.getCriteriaBuilder().createQuery(Currency.class);
        criteria.select(criteria.from(Currency.class));
        return entityManager.createQuery(criteria).getResultList();
    }
}
