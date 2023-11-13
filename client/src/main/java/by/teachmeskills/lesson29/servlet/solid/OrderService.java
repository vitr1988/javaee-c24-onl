package by.teachmeskills.lesson29.servlet.solid;

import by.teachmeskills.lesson29.servlet.solid.domain.Order;

public class OrderService {

    private OrderValidator validator = new OrderValidator();
    private OrderStorage storage = new OrderStorage();
    private NotificationService notificationService = new NotificationService();

    public void process(Order order) {
//        Transaction transaction; // begin transaction
        System.out.println("process(order => " + order);
        if (!validator.isValid(order)) {
            System.out.println("Validation was failed");
            return;
        }
        System.out.println("Validation was successfull");
        storage.save(order);
        notificationService.sendNotification(order);
//        transaction.commit(); // commit;
    }
}
