package com.paranoidal97.OrdersMicroservice.model.dto;

import com.paranoidal97.OrdersMicroservice.model.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Builder
public class OrderRequestDto {
    private final Long cartId;
    private final Long userId;
}
