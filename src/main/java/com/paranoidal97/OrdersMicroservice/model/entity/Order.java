package com.paranoidal97.OrdersMicroservice.model.entity;

import com.paranoidal97.OrdersMicroservice.model.Cart;
import com.paranoidal97.OrdersMicroservice.model.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table
@ToString
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long cartId;
    private OrderStatus status;
    private Long userId;

}
