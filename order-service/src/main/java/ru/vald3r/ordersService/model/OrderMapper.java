package ru.vald3r.ordersService.model;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface OrderMapper {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "productId", target = "productId")
    Order orderDtoToOrder(OrderDto orderDto);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "productId", target = "productId")
    OrderDto orderToOrderDto(Order order);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateOrderFromOrderDto(OrderDto orderDto, @MappingTarget Order order);
}
