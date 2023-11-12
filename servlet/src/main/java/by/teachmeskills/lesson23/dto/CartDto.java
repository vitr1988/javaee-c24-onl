package by.teachmeskills.lesson23.dto;

import lombok.Data;

import java.util.List;

@Data
public class CartDto {

    private String login;
    private List<ProductDto> productList;

}
