package ru.sapteh.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.sapteh.Dao.DAO;
import ru.sapteh.model.ProductSale;

import java.util.List;

public class ProductSaleService implements DAO<ProductSale, Integer> {
    final SessionFactory factory;

    public ProductSaleService(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(ProductSale productSale) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.save(productSale);
            session.getTransaction().commit();

        }

    }

    @Override
    public ProductSale read(Integer integer) {
        try(Session session = factory.openSession()){
            ProductSale productSale = session.get(ProductSale.class, integer);
            return productSale;
        }

    }

    @Override
    public List<ProductSale> readAll() {
        try(Session session = factory.openSession()){
            Query result = session.createQuery("FROM ProductSale");
            return result.getResultList();
        }
    }

    @Override
    public void update(ProductSale productSale) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.update(productSale);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(ProductSale productSale) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(productSale);
            session.getTransaction().commit();

        }
    }
}
