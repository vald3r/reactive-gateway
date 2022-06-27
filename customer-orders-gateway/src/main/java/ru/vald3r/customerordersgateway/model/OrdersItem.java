package ru.vald3r.customerordersgateway.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class OrdersItem {
    Long id;
    Long productId;
    String productTitle;
}