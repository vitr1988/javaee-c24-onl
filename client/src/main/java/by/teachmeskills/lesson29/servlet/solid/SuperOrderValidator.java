package by.teachmeskills.lesson29.servlet.solid;

import by.teachmeskills.lesson29.servlet.solid.domain.Order;
import by.teachmeskills.lesson29.servlet.solid.domain.Product;

public class SuperOrderValidator extends OrderValidator {

    @Override
    public boolean isValid(Order order) {
        boolean valid = super.isValid(order);
        if (valid) {
            for (Product product: order.getProducts()) {
                if (product.getName() == null || product.getName().isBlank()) {
                    throw new IllegalStateException("Product must have name!");
                }
            }
        }
        return valid;
    }
}
