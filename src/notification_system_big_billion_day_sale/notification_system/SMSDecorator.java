package notification_system_big_billion_day_sale.notification_system;

import notification_system_big_billion_day_sale.ObserverData;

public class SMSDecorator extends ChannelDecorator {
    public SMSDecorator(NotificationChannel wrappedChannel) {
        super(wrappedChannel);
    }

    public void sendNotification(NotificationData notificationData) {
        super.sendNotification(notificationData);
        sendSMS(notificationData);

    }

    public void sendSMS(NotificationData notificationData) {
        ObserverData observerData = notificationData.getObserverData();
        System.out.println("Sending SMS to:"
                + observerData.getName() + "-" + observerData.getPhoneNo()
                + " " + notificationData.getMessage());
    }
}
