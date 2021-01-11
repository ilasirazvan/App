package com.example.basket.controller;

import com.example.basket.dto.OrderDTO;
import com.example.basket.service.OrderService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/orders")
public class OrderController {

    @Inject
    OrderService orderService;

    @GET
    @Path("")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<OrderDTO> getOrder() {
        return orderService.getCategories();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public OrderDTO getOrder(@PathParam("id") String orderId) {
        return orderService.getOrder(orderId);
    }

}
