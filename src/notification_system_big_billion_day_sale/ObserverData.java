package notification_system_big_billion_day_sale;

import notification_system_big_billion_day_sale.notification_system.NotificationChannel;

public class ObserverData {
    String id;
    String name;
    String email;
    String phoneNo;

    NotificationChannel subscribedNotificationChannel;

    //String deviceType; (optional)
    ObserverData(String id, String name, String email, String phoneNo) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setSubscribedNotificationChannel(NotificationChannel subscribedNotificationChannel) {
        this.subscribedNotificationChannel = subscribedNotificationChannel;
    }

    public NotificationChannel getSubscribedNotificationChannel() {
        return subscribedNotificationChannel;
    }
}
