package ru.sapteh;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.sapteh.Dao.DAO;
import ru.sapteh.model.Manufacturer;
import ru.sapteh.model.Product;
import ru.sapteh.model.ProductSale;
import ru.sapteh.service.ManufacturerService;
import ru.sapteh.service.ProductSaleService;
import ru.sapteh.service.ProductService;

public class Main {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        DAO<Manufacturer, Integer> manufactureDao = new ManufacturerService(factory);
        DAO<Product, Integer> productDao = new ProductService(factory);
        DAO<ProductSale, Integer> productSaleDao = new ProductSaleService(factory);

        Product product = productDao.read(1);





    }
}
