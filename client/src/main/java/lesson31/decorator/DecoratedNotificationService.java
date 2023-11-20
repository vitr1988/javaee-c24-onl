package lesson31.decorator;

public interface DecoratedNotificationService extends NotificationService {

    boolean checkStatus(String clientId);
}
