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
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    @Override
    public List<OrderResponseDto> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream()
                .map(orderMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<OrderResponseDto> getAllOrdersByUser(Long id) {
        List<Order> orders = orderRepository.findAllByUserId(id);
        return orders.stream()
                .map(orderMapper::toDto)
                .collect(Collectors.toList());
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
        log.info("Order to create: {}", order.toString());
        Order orderEntity = orderMapper.toEntity(order);
        log.info("Order Entity after mapping: {}", orderEntity.toString());
        orderEntity.setStatus(OrderStatus.CREATED);
        orderRepository.save(orderEntity);
        return orderMapper.toDto(orderEntity);
    }

    @Override
    public OrderResponseDto changeStatus(Long id, OrderStatus orderStatus) {
        Order order = orderRepository.findById(id)
                .orElseThrow(
                        () -> new DataNotFoundException("There is no such Order")
                );
        if (order.getStatus().isTransitionAllowed(orderStatus)) {
            order.setStatus(orderStatus);
        } else {
            throw new IllegalApointmentTransition("nie można ");
        }
        orderRepository.save(order);
        return orderMapper.toDto(order);
    }
}
