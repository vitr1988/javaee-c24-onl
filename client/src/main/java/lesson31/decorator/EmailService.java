package lesson31.decorator;

public class EmailService implements NotificationService {
    @Override
    public void send(String email) {
        System.out.println("Email sent to client " + email);
    }
}
