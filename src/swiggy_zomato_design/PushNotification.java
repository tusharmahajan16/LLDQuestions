package swiggy_zomato_design;

public class PushNotification implements NotificationSender {
    @Override
    public void sendNotifications(String userId, String msg) {
        System.out.println("Push Notification for "+userId+" is "+msg);
    }
}
