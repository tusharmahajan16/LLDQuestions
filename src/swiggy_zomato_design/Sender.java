package swiggy_zomato_design;

public class Sender {
    String userId;
    NotificationSender notificationSender;
    public Sender(String userId, NotificationSender notificationSender) {
        this.userId = userId;
        this.notificationSender = notificationSender;
    }

    public String getUserId() {
        return userId;
    }

    public NotificationSender getNotificationSender() {
        return notificationSender;
    }
}
