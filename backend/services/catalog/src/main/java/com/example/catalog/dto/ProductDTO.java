package com.example.catalog.dto;

public class ProductDTO {

    private String id;
    private String name;
    private String description;
    private Integer units;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getUnits() {
        return units;
    }

    public void setUnits(Integer units) {
        this.units = units;
    }

    public ProductDTO() {
    }

    public ProductDTO(String id, String name, String description, Integer units) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.units = units;
    }
}
