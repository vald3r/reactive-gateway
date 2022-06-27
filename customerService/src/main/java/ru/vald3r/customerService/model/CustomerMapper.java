package ru.vald3r.customerService.model;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface CustomerMapper {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    Customer customerDtoToCustomer(CustomerDto customerDto);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    CustomerDto customerToCustomerDto(Customer customer);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateCustomerFromCustomerDto(CustomerDto customerDto, @MappingTarget Customer customer);
}
