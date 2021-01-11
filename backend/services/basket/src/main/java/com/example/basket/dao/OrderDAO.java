package com.example.basket.dao;

import com.example.basket.entity.Order;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@Transactional
public class OrderDAO {

    @PersistenceContext(unitName = "basket-pu")
    EntityManager entityManager;

    public List<Order> getOrders() {
        return entityManager.createQuery("SELECT o FROM Order o").getResultList();
    }

    public boolean addOrder(Order order) {
        try {
            entityManager.persist(order);
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

    public Order getOrder(String orderId) {
        return entityManager.find(Order.class, orderId);
    }

}
