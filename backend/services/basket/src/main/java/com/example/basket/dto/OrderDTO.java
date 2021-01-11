package com.example.basket.dto;

public class OrderDTO {

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public OrderDTO() {
    }

    public OrderDTO(String id) {
        this.id = id;
    }
}
