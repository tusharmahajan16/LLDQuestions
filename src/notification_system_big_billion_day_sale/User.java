package notification_system_big_billion_day_sale;

import notification_system_big_billion_day_sale.abstracts.Observer;
import notification_system_big_billion_day_sale.notification_system.NotificationData;
import notification_system_big_billion_day_sale.notification_system.NotificationManager;

class User implements Observer {
    private ObserverData observerData;

    User(ObserverData observerData) {
        this.observerData = observerData;
    }

    public ObserverData getObserverData() {
        return observerData;
    }

    @Override
    public void update(String message) {
        NotificationData notificationData = new NotificationData(observerData,message);
        NotificationManager notificationManager = new NotificationManager(observerData.getSubscribedNotificationChannel());
        notificationManager.sendNotifications(notificationData);
    }
}
