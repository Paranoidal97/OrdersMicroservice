package com.paranoidal97.OrdersMicroservice.model.dto;

import com.paranoidal97.OrdersMicroservice.model.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class OrderResponseDto {
    private final Long id;
    private final Long cartId;
    private final OrderStatus status;
    private final Long userId;
}
