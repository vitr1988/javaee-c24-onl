package by.teachmeskills.lesson29.servlet.solid;

public interface AbstractSmsNotificationService extends AbstractNotificationService {
    void sendSms(String phone);

}
