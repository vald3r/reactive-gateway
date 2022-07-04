package ru.vald3r.orderservice.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class OrderDto {
    private Long id;
    private Long productId;
}
