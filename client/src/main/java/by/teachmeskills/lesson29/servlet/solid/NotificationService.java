package by.teachmeskills.lesson29.servlet.solid;

import by.teachmeskills.lesson29.servlet.solid.domain.Order;

public class NotificationService implements AbstractNotificationService {

    private AbstractPushNotificationService pushNotificationService = new PushNotificationService();

    @Override
    public void sendNotification(Order order) {
        String supplier = order.getSupplier();
        if (supplier != null && !supplier.isBlank()) {
            pushNotificationService.sendPush(supplier);
        }
    }
}
