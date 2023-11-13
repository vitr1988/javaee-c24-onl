package by.teachmeskills.lesson29.servlet.solid;

import by.teachmeskills.lesson29.servlet.solid.domain.Order;

public class OrderService {

    private OrderValidator validator = new SuperOrderValidator();
    private OrderStorage storage = new OrderStorage();
    private NotificationService notificationService = new NotificationService();

    public void process(Order order) {
        System.out.println("process(order => " + order + ")");
        if (!validator.isValid(order)) {
            System.out.println("failed process(order => " + order + ")");
        }
        storage.save(order);
        notificationService.sendNotification(order);
        System.out.println("sucessful processing(order => " + order + ")");
    }
}

