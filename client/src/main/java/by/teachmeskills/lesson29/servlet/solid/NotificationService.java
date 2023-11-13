package by.teachmeskills.lesson29.servlet.solid;

import by.teachmeskills.lesson29.servlet.solid.domain.Order;

public class NotificationService {

    public void sendNotification(Order order) {
        String supplier = order.getSupplier();
        if (supplier != null && !supplier.isBlank()) {
            sendEmail(supplier);
        }
    }

    private void sendEmail(String supplier) {
    }
}
