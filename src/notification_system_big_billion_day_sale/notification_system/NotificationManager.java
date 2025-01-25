package notification_system_big_billion_day_sale.notification_system;

public class NotificationManager {
    NotificationChannel notificationChannel;


    public NotificationManager(NotificationChannel notificationChannel) {
        this.notificationChannel = notificationChannel;
    }

    public void sendNotifications(NotificationData notificationData) {
        notificationChannel.sendNotification(notificationData);
    }
}
