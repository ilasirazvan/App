package com.example.basket.dao;

import com.example.basket.entity.Order;
import com.example.basket.entity.OrderDetail;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@Transactional
public class OrderDetailDAO {

    @PersistenceContext(unitName = "basket-pu")
    EntityManager entityManager;

    public List<Order> getOrderDetails() {
        return entityManager.createQuery("SELECT od FROM OrderDetail od").getResultList();
    }

    public boolean addOrderDetails(OrderDetail orderDetail) {
        try {
            entityManager.persist(orderDetail);
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

    public OrderDetail getOrderDetail(String orderDetailId) {
        return entityManager.find(OrderDetail.class, orderDetailId);
    }

}
