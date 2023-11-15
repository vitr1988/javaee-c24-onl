package by.teachmeskills.lesson30;

import by.teachmeskills.lesson30.dto.CategoryEnum;
import by.teachmeskills.lesson30.dto.Order;
import by.teachmeskills.lesson30.dto.Product;

import java.math.BigDecimal;

public class BuilderExample {
    public static void main(String[] args) {
        Product milk = Product.builder(1, "Milk")
                        .category(CategoryEnum.DRINKABLE)
                        .price(new BigDecimal("100"))
                        .shop("Auchan")
                        .weight(1)
                        .size(250)
                        .build();
//        Product milk2 = new Product(5, "Milk", CategoryEnum.DRINKABLE, new BigDecimal("108"), "Auchan", 2, 300);

        Product car = Product.builder(7, "Bmw")
                .price(new BigDecimal("10000000"))
                .build();
        //new Product(7, "Bmw");

        Order order = new Order();
        order.setId(1).setCustomerName("Vitaly");
    }
}
