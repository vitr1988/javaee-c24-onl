package lesson31.decorator;

public class PushService implements NotificationService {
    @Override
    public void send(String phone) {
        System.out.println("Push sent to client " + phone);
    }
}
