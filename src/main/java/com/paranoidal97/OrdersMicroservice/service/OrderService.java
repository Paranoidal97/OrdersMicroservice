package com.paranoidal97.OrdersMicroservice.service;

import com.paranoidal97.OrdersMicroservice.model.dto.OrderRequestDto;
import com.paranoidal97.OrdersMicroservice.model.dto.OrderResponseDto;
import com.paranoidal97.OrdersMicroservice.model.enums.OrderStatus;

import java.util.List;

public interface OrderService {
    public List<OrderResponseDto> getAllOrders();

    public List<OrderResponseDto> getAllOrdersByUser(Long id);

    public OrderResponseDto getOrderById(Long id);

    public OrderResponseDto createOrder(OrderRequestDto order);

    public OrderResponseDto changeStatus(Long id, OrderStatus orderStatus);
}
