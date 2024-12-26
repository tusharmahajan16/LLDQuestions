package swiggy_zomato_design;

public class User {
    String name;
    Location location;

    User(String name, Location location) {
        this.name = name;
        this.location = location;
    }
    public String getName() {
        return name;
    }
    public Location getLocation() {
        return location;
    }

    public void addUsersForNotifications(String orderId)
    {
        NotificationMgr notificationMgr = NotificationMgr.getInstance();
        //we can add push or whatsapp notifications in same way. Basically, we are keeping all notifications customisable
        notificationMgr.addNotificationSender(orderId,name,new SmsNotification());
        //this configuration level should be in user class and not in order mgr
    }
}
