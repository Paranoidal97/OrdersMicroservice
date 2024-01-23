package com.paranoidal97.OrdersMicroservice.model.enums;

import com.paranoidal97.OrdersMicroservice.exception.IllegalApointmentTransition;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@RequiredArgsConstructor
public enum OrderStatus {
    CREATED(Set.of("SCHEDULED", "CANCELLED")),
    SCHEDULED(Set.of("CANCELLED", "IN_DELIVERY")),
    CANCELLED(Set.of()),
    IN_DELIVERY(Set.of("COMPLETED")),
    COMPLETED(Set.of());

    private final Set<String> allowedTransitions;

    public boolean isTransitionAllowed(OrderStatus orderStatus) {
        if (!(allowedTransitions.contains(orderStatus.toString()))) {
            throw new IllegalApointmentTransition(
                    "This status transition from state is illegal"
            );
        }
        return true;
    }
}

