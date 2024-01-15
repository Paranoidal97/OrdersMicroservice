package com.paranoidal97.OrdersMicroservice.service.impl;

import com.paranoidal97.OrdersMicroservice.exception.DataNotFoundException;
import com.paranoidal97.OrdersMicroservice.exception.IllegalApointmentTransition;
import com.paranoidal97.OrdersMicroservice.mapper.OrderMapper;
import com.paranoidal97.OrdersMicroservice.model.dto.OrderRequestDto;
import com.paranoidal97.OrdersMicroservice.model.dto.OrderResponseDto;
import com.paranoidal97.OrdersMicroservice.model.entity.Order;
import com.paranoidal97.OrdersMicroservice.model.enums.OrderStatus;
import com.paranoidal97.OrdersMicroservice.repository.OrderRepository;
import com.paranoidal97.OrdersMicroservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    @Override
    public List<OrderResponseDto> getAllOrders() {
        return null;
    }

    @Override
    public List<OrderResponseDto> getAllOrdersByUser(Long id) {
        return null;
    }

    @Override
    public OrderResponseDto getOrderById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(
                        () -> new DataNotFoundException("There is no such order")
                );
        return orderMapper.toDto(order);
    }

    @Override
    public OrderResponseDto createOrder(OrderRequestDto order) {
        Order entity = orderMapper.toEntity(order);
        entity.setStatus(OrderStatus.CREATED);
        orderRepository.save(entity);
        return orderMapper.toDto(entity);
    }

    @Override
    public OrderResponseDto changeStatus(Long id,OrderStatus orderStatus) {
        Order order = orderRepository.findById(id)
                .orElseThrow(
                        () -> new DataNotFoundException("There is no such Order")
                );
        if(order.getStatus().isTransitionAllowed(orderStatus)){
            order.setStatus(orderStatus);
        } else {
            throw new IllegalApointmentTransition("nie można //TODO");//TODO
        }
        orderRepository.save(order);
        return orderMapper.toDto(order);
    }
}
