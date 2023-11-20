package lesson31.decorator;

public class NotificationSystem {

    public static void main(String[] args) {
        DecoratedNotificationService notificationService =
                new UniversalNotificationService(new EmailService(), new TelegramService());
        notificationService.send("test@mail.ru");
        notificationService.checkStatus("test@mail.ru");
    }
}
