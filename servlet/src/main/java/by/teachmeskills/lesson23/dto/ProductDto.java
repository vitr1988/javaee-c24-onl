package by.teachmeskills.lesson23.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDto {
    private final String name;
    private final BigDecimal price;
}
