package com.paranoidal97.OrdersMicroservice.repository;

import com.paranoidal97.OrdersMicroservice.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
