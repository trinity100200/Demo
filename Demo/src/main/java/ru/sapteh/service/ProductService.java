package ru.sapteh.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.sapteh.Dao.DAO;
import ru.sapteh.model.Product;

import java.util.List;

public class ProductService implements DAO<Product, Integer> {
    final SessionFactory factory;

    public ProductService(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(Product product) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.save(product);
            session.getTransaction().commit();

        }
    }

    @Override
    public Product read(Integer integer) {
        try(Session session = factory.openSession()){
            Product product = session.get(Product.class, integer);
            return product;
        }
    }

    @Override
    public List<Product> readAll() {
        try(Session session = factory.openSession()){
            Query result = session.createQuery("FROM Product");
            return result.getResultList();
        }
    }

    @Override
    public void update(Product product) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.update(product);
            session.getTransaction().commit();

        }

    }

    @Override
    public void delete(Product product) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(product);
            session.getTransaction().commit();

        }

    }
}
