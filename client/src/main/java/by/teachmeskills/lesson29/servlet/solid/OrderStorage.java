package by.teachmeskills.lesson29.servlet.solid;

import by.teachmeskills.lesson29.servlet.solid.domain.Order;

public interface OrderStorage {

    boolean save(Order order);
}
