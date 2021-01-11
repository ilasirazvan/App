package com.example.basket.entity;

import javax.persistence.*;

@Entity
@Table(name = "order")
public class Order {

    @Id
    private String id;

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "status", nullable = false)
    private String status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Order() {
    }

    public Order(String id, String userId, String status) {
        this.id = id;
        this.userId = userId;
        this.status = status;
    }
}
