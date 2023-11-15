package by.teachmeskills.lesson30.dto;

import lombok.Setter;
import lombok.experimental.Accessors;

@Setter
@Accessors(chain = true)
public class Order {

    private Integer id;
    private String customerName;

}

