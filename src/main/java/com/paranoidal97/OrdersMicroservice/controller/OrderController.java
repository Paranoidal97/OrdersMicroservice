package com.paranoidal97.OrdersMicroservice.controller;

import com.paranoidal97.OrdersMicroservice.model.dto.OrderRequestDto;
import com.paranoidal97.OrdersMicroservice.model.dto.OrderResponseDto;
import com.paranoidal97.OrdersMicroservice.model.entity.Order;
import com.paranoidal97.OrdersMicroservice.model.enums.OrderStatus;
import com.paranoidal97.OrdersMicroservice.service.impl.OrderServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {
    public final OrderServiceImpl orderService;
    @PostMapping
    public OrderResponseDto createOrder(OrderRequestDto order){
        return orderService.createOrder(order);
    }

    @GetMapping
    public List<OrderResponseDto> getAllOrders(){
        return orderService.getAllOrders();
    }

    @GetMapping("/id/{id}")
    public OrderResponseDto getOrderById(@PathVariable Long id){
        return orderService.getOrderById(id);
    }

    @GetMapping("/user/{id}")
    public List<OrderResponseDto> getAllOrdersByUser(@PathVariable Long id){
        return orderService.getAllOrdersByUser(id);
    }

    @PatchMapping("/{id}")
    public OrderResponseDto changeStatus(@PathVariable Long id, @RequestBody OrderStatus orderStatus){
        return orderService.changeStatus(id, orderStatus);
    }

}
