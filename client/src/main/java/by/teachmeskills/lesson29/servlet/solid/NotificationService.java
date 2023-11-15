package by.teachmeskills.lesson29.servlet.solid;

import by.teachmeskills.lesson29.servlet.solid.domain.Order;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class NotificationService implements AbstractNotificationService {

    private static AbstractNotificationService INSTANCE;

    private AbstractPushNotificationService pushNotificationService2 = new PushNotificationService();

    @Override
    public void sendNotification(Order order) {
        String supplier = order.getSupplier();
        if (supplier != null && !supplier.isBlank()) {
            pushNotificationService2.sendPush(supplier);
        }
    }

    public static AbstractNotificationService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new NotificationService();
        }
        return INSTANCE;
    }

    private static AbstractNotificationService smsNotificationService;
    private static AbstractNotificationService pushNotificationService;
    private static AbstractNotificationService emailNotificationService;

    public static AbstractNotificationService getInstance(NotificationType type) {
        AbstractNotificationService notificationService = null;
        switch (type) {
            case SMS : {
                if (smsNotificationService == null) {
                    smsNotificationService = new SmsNotificationService();
                }
                notificationService = smsNotificationService;
                break;
            }
            case PUSH : {
                if (pushNotificationService == null) {
                    pushNotificationService = new PushNotificationService();
                }
                notificationService = pushNotificationService;
                break;
            }
            case EMAIL: {
                if (emailNotificationService == null) {
                    emailNotificationService = new EmailNotificationService();
                }
                notificationService = emailNotificationService;
                break;
            }
        };
        return notificationService;
    }
}
