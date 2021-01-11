package com.example.catalog.dao;

import com.example.catalog.entity.Product;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class ProductDAO {

    @PersistenceContext(unitName = "catalog-pu")
    EntityManager entityManager;

    public List<Product> getProducts() {
        return entityManager.createQuery("SELECT p FROM Product p").getResultList();
    }

    @Transactional
    public boolean addProduct(Product product) {
        try{
            entityManager.persist(product);
        } catch (Exception ex){
            return false;
        }
        return true;
    }

    public Product getProduct(String productId) {
        return entityManager.find(Product.class, productId);
    }

    @Transactional
    public boolean updateProduct(Product product) {
        try{
            entityManager.merge(product);
        } catch (Exception ex){
            return false;
        }
        return true;
    }
}
