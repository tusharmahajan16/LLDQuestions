package swiggy_zomato_design;

public class SmsNotification implements NotificationSender {
    @Override
    public void sendNotifications(String userId, String msg) {
        System.out.println("SMS Notification for "+userId+" is "+msg);
    }
}
