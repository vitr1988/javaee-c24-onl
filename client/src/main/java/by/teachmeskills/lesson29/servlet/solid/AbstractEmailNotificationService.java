package by.teachmeskills.lesson29.servlet.solid;

public interface AbstractEmailNotificationService extends AbstractNotificationService {

    void sendEmail(String email);
}
