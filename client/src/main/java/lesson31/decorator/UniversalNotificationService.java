package lesson31.decorator;

import java.util.List;

public class UniversalNotificationService implements DecoratedNotificationService {

    private List<NotificationService> notificationServices;

    public UniversalNotificationService(NotificationService... notificationServices) {
        this.notificationServices = List.of(notificationServices);
    }

    @Override
    public void send(String clientIdentifier) {
        notificationServices.forEach(it -> it.send(clientIdentifier));
    }

    @Override
    public boolean checkStatus(String clientIdentifier) {
        return false;
    }
}
