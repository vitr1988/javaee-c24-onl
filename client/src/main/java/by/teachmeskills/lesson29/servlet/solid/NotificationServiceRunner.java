package by.teachmeskills.lesson29.servlet.solid;

public class NotificationServiceRunner {

    public static void main(String[] args) {
        AbstractNotificationService instance = NotificationService.getInstance(NotificationType.EMAIL);
        AbstractNotificationService instance2 = NotificationService.getInstance(NotificationType.EMAIL);
        AbstractNotificationService instance3 = NotificationService.getInstance(NotificationType.SMS);
        AbstractNotificationService instance4 = NotificationService.getInstance(NotificationType.SMS);
        System.out.println(instance == instance4);
        System.out.println(instance2 == instance3);
    }
}
