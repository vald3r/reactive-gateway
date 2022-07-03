package ru.vald3r.orderservice.model;

import lombok.Data;

@Data
public class OrderDto {
    private Long id;
    private Long productId;
}
