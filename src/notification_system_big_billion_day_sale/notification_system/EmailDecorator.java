package notification_system_big_billion_day_sale.notification_system;

import notification_system_big_billion_day_sale.ObserverData;
import notification_system_big_billion_day_sale.abstracts.Observer;

public class EmailDecorator extends ChannelDecorator {
    public EmailDecorator(NotificationChannel wrappedChannel) {
        super(wrappedChannel);

    }

    public void sendNotification(NotificationData notificationData) {
        super.sendNotification(notificationData);
        sendEmail(notificationData);

    }

    public void sendEmail(NotificationData notificationData) {
        ObserverData observerData = notificationData.getObserverData();
        System.out.println("Sending Email to:"
                + observerData.getName() + "-" + observerData.getEmail()
                + " " + notificationData.getMessage());
    }
}
