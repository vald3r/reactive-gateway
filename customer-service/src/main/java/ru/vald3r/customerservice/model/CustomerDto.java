package ru.vald3r.customerservice.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class CustomerDto {
    private Long id;
    private String name;
}
