package by.teachmeskills.lesson29.servlet.solid;

import by.teachmeskills.lesson29.servlet.solid.domain.Order;
import by.teachmeskills.lesson29.servlet.solid.domain.Product;

import java.util.List;

public class OrderValidator implements Validator<Order> {

    @Override
    public boolean isValid(Order order) {
        List<Product> products = order.getProducts();
        if (products == null || products.isEmpty()) {
            return false;
        }
        for (Product product: products) {
            if (product.getId() == null || product.getPrice() == null) {
                return false;
            }
        }
        return true;
    }
}
