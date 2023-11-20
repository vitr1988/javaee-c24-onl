package lesson31.decorator;

public class TelegramService implements NotificationService {
    @Override
    public void send(String telegramId) {
        System.out.println("Telegram message sent to client " + telegramId);
    }
}
