package swiggy_zomato_design;

import java.util.HashMap;

public class Restaurant {
    String name;
    Location location;
    boolean available;
    Menu menu;
    RestaurantOwner restaurantOwner;

    public Restaurant(String name, Location location, RestaurantOwner restaurantOwner) {
        this.name = name;
        this.location = location;
        this.restaurantOwner = restaurantOwner;
    }

    public String getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    //prepareFood()
    boolean prepareFood(String orderId, HashMap<Dish,Integer> dishes)
    {
        System.out.println(name+" Restaurant accepting the order and starting to prepare it");
        NotificationMgr notificationMgr = NotificationMgr.getInstance();
        notificationMgr.notify(orderId, "Food is being prepared in restaurant");
        Common.addDelay();
        notificationMgr.notify(orderId, "Food is ready and can be picked up from restaurant");
        return true;
    }

    void addRestaurantForNotifications(String orderId) {
        NotificationMgr notificationMgr = NotificationMgr.getInstance();
        //we can add push or whatsapp notifications in same way. Basically, we are keeping all notifications customisable
        notificationMgr.addNotificationSender(orderId, name, new PushNotification());
    }
}
