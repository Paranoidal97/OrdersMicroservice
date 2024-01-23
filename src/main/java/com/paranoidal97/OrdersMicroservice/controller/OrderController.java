package com.paranoidal97.OrdersMicroservice.controller;

import com.paranoidal97.OrdersMicroservice.model.dto.OrderRequestDto;
import com.paranoidal97.OrdersMicroservice.model.dto.OrderResponseDto;
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

    @GetMapping
    public List<OrderResponseDto> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public OrderResponseDto getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @GetMapping("/{id}/user")
    public List<OrderResponseDto> getAllOrdersByUser(@PathVariable Long id) {
        return orderService.getAllOrdersByUser(id);
    }

    @PostMapping
    public OrderResponseDto createOrder(@RequestBody OrderRequestDto order) {
        return orderService.createOrder(order);
    }

    @PatchMapping("/{id}")
    public OrderResponseDto changeStatus(@PathVariable Long id, @RequestParam OrderStatus orderStatus) {
        return orderService.changeStatus(id, orderStatus);
    }

}
