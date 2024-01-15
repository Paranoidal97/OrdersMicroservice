package com.paranoidal97.OrdersMicroservice.mapper;

import com.paranoidal97.OrdersMicroservice.model.dto.OrderRequestDto;
import com.paranoidal97.OrdersMicroservice.model.dto.OrderResponseDto;
import com.paranoidal97.OrdersMicroservice.model.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface OrderMapper {
    Order toEntity(OrderRequestDto order);
    OrderResponseDto toDto(Order order);
}
