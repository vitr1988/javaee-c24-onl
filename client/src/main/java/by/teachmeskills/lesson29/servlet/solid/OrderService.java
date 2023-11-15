package by.teachmeskills.lesson29.servlet.solid;

import by.teachmeskills.lesson29.servlet.solid.domain.Order;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class OrderService {

    @Setter
    private Validator<Order> validator = new SuperOrderValidator();

    @Setter
    private OrderStorage storage = new DbOrderStorage();

    @Setter
    private AbstractNotificationService notificationService = new NotificationService();

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

