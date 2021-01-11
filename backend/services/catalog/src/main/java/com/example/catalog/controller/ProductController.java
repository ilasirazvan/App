package com.example.catalog.controller;

import com.example.catalog.dto.ProductDTO;
import com.example.catalog.service.ProductService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/products")
@ApplicationScoped
public class ProductController {

    @Inject
    ProductService productService;

    @GET
    @Path("")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProductDTO> getProducts() {
        return productService.getProducts();
    }

    @POST
    @Path("")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public boolean addProduct(ProductDTO productDTO) {
        return productService.addProduct(productDTO);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public boolean updateProduct(ProductDTO productDTO) {
        return productService.updateProduct(productDTO);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ProductDTO getProduct(@PathParam("id") String productId) {
        return productService.getProduct(productId);
    }
}
