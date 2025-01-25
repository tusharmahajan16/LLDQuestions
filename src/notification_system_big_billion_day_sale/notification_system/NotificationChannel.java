package notification_system_big_billion_day_sale.notification_system;

import notification_system_big_billion_day_sale.ObserverData;

public interface NotificationChannel {
    void sendNotification(NotificationData notificationData);
}
