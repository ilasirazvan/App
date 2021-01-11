package com.example.catalog.service;

import com.example.catalog.dao.ProductDAO;
import com.example.catalog.dto.ProductDTO;
import com.example.catalog.entity.Product;
import org.modelmapper.ModelMapper;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@ApplicationScoped
public class ProductService {

    @Inject
    ProductDAO productDAO;

    ModelMapper modelMapper = new ModelMapper();

    public boolean addProduct(ProductDTO productDTO) {
        productDTO.setId(UUID.randomUUID().toString());
        return productDAO.addProduct(modelMapper.map(productDTO, Product.class));
    }

    public ProductDTO getProduct(String productId) {
        return modelMapper.map(productDAO.getProduct(productId), ProductDTO.class);
    }

    public List<ProductDTO> getProducts() {
        return productDAO.getProducts()
                .stream()
                .map(product -> modelMapper.map(product, ProductDTO.class))
                .collect(Collectors.toList());
    }

    public boolean updateProduct(ProductDTO productDTO) {
        return productDAO.updateProduct(modelMapper.map(productDTO, Product.class));
    }
}
