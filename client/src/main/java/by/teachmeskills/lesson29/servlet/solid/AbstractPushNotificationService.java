package by.teachmeskills.lesson29.servlet.solid;

public interface AbstractPushNotificationService extends AbstractNotificationService {

    void sendPush(String phone);
}
