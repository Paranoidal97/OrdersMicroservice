package com.paranoidal97.OrdersMicroservice.model.dto;

import com.paranoidal97.OrdersMicroservice.model.Cart;
import com.paranoidal97.OrdersMicroservice.model.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class OrderResponseDto {
    private Long id;
    private Long cartId;
    private OrderStatus status;
    private Long userId;
}
