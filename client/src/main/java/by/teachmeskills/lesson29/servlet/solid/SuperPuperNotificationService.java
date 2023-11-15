package by.teachmeskills.lesson29.servlet.solid;

import by.teachmeskills.lesson29.servlet.solid.domain.Order;

public class SuperPuperNotificationService implements AbstractSmsNotificationService, AbstractPushNotificationService,
        AbstractEmailNotificationService {

    @Override
    public void sendEmail(String email) {

    }

    @Override
    public void sendNotification(Order order) {

    }

    @Override
    public void sendSms(String phone) {

    }

    @Override
    public void sendPush(String phone) {

    }
}
