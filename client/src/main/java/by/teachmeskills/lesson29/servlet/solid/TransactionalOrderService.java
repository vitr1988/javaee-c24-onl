package by.teachmeskills.lesson29.servlet.solid;

import by.teachmeskills.lesson29.servlet.solid.domain.Order;

public class TransactionalOrderService extends OrderService {

    @Override
    public void process(Order order) {
//        Transaction transaction;
        super.process(order);
//        transaction.commit();
    }
}
