package com.paranoidal97.OrdersMicroservice.model.entity;

import com.paranoidal97.OrdersMicroservice.model.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long cartId;
    private OrderStatus status;
    private Long userId;

}
