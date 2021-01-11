package com.example.basket.service;

import com.example.basket.dao.OrderDAO;
import com.example.basket.dto.OrderDTO;
import com.example.basket.entity.Order;
import org.modelmapper.ModelMapper;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@ApplicationScoped
public class OrderService {

    @Inject
    OrderDAO orderDAO;

    ModelMapper modelMapper = new ModelMapper();

    public boolean addOrder(OrderDTO orderDTO) {
        orderDTO.setId(UUID.randomUUID().toString());
        return orderDAO.addOrder(modelMapper.map(orderDTO, Order.class));
    }

    public OrderDTO getOrder(String orderId) {
        return modelMapper.map(orderDAO.getOrder(orderId), OrderDTO.class);
    }

    public List<OrderDTO> getCategories() {
        return orderDAO.getOrders()
                .stream()
                .map(order -> modelMapper.map(order, OrderDTO.class))
                .collect(Collectors.toList());
    }
}
