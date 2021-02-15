package ru.sapteh.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.sapteh.Dao.DAO;
import ru.sapteh.model.Manufacturer;

import java.util.List;

public class ManufacturerService implements DAO<Manufacturer, Integer> {
    final SessionFactory factory;

    public ManufacturerService(SessionFactory factory) {
        this.factory = factory;
    }

    public void create(Manufacturer manufacturer) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.save(manufacturer);
            session.getTransaction().commit();
        }
    }

    public Manufacturer read(Integer integer) {
        try(Session session = factory.openSession()){
            Manufacturer manufacturer =session.get(Manufacturer.class, integer);
            return manufacturer;
        }
    }

    public List<Manufacturer> readAll() {
        try(Session session = factory.openSession()){
            Query result = session.createQuery("FROM Manufacturer");
            return result.getResultList();
        }

    }

    public void update(Manufacturer manufacturer) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.update(manufacturer);
            session.getTransaction().commit();
        }
    }

    public void delete(Manufacturer manufacturer) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(manufacturer);
            session.getTransaction();

        }

    }
}
