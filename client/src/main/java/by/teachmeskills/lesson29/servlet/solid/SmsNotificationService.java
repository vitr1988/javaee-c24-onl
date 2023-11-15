package by.teachmeskills.lesson29.servlet.solid;

import by.teachmeskills.lesson29.servlet.solid.domain.Order;
import by.teachmeskills.lesson29.servlet.solid.exception.NotImplementedYetException;

public class SmsNotificationService implements AbstractSmsNotificationService {

    @Override
    public void sendNotification(Order order) {
        throw new NotImplementedYetException(SmsNotificationService.class.getSimpleName());
    }

    @Override
    public void sendSms(String phone) {
        //TODO:
    }
}
