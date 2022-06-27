package ru.vald3r.productService.model;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ProductMapper {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "title", target = "title")
    Product productDtoToProduct(ProductDto productDto);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "title", target = "title")
    ProductDto productToProductDto(Product product);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateProductFromProductDto(ProductDto productDto, @MappingTarget Product product);
}
