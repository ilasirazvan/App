package com.example.basket.entity;

import javax.persistence.*;

@Entity
@Table(name = "order_details")
public class OrderDetail {

    @Id
    private String id;

    @ManyToOne()
    @JoinColumn(name = "order_id")
    private Order order;

    @Column(name = "product_id", nullable = false)
    private String productId;

    @Column(name = "units", nullable = false)
    private Integer units;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Integer getUnits() {
        return units;
    }

    public void setUnits(Integer units) {
        this.units = units;
    }

    public OrderDetail() {
    }

    public OrderDetail(String id, Order order, String productId, Integer units) {
        this.id = id;
        this.order = order;
        this.productId = productId;
        this.units = units;
    }
}
