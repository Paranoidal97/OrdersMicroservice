package com.paranoidal97.OrdersMicroservice.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import org.hibernate.annotations.CreationTimestamp;

import java.time.OffsetTime;
import java.util.List;

public class Cart {
    private Long id;
    private OffsetTime createdAt;
}
