package by.teachmeskills.lesson29.servlet.solid.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
public class Order {

    private String supplier;

    private List<Product> products = new ArrayList<>();

    public void add(Product product) {
        products.add(product);
    }

    public BigDecimal getTotal() {
        BigDecimal result = BigDecimal.ZERO;
        for(Product product: products) {
            result.add(product.getPrice());
        }
        return result;
    }
}
