package by.teachmeskills.lesson29.servlet.solid;

import by.teachmeskills.lesson29.servlet.solid.domain.Order;
import by.teachmeskills.lesson29.servlet.solid.domain.Product;

import java.math.BigDecimal;

public class OrderRunner {

    private static final OrderService ORDER_SERVICE = new TransactionalOrderService();

    public static void main(String[] args) {
        Order order = new Order();
        order.add(new Product(1L, "Milk", new BigDecimal("100")));
        order.add(new Product(2L, "Bread", new BigDecimal("50")));
        order.add(new Product(3L, "Cheese", new BigDecimal("500")));
        order.add(new Product(4L, "Meat", new BigDecimal("1000")));
        order.add(new Product(5L, null, new BigDecimal("5000")));
        ORDER_SERVICE.process(order);


        String content = "Example";
        System.out.println(content);
    }
}
