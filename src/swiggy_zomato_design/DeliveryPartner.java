package swiggy_zomato_design;


public class DeliveryPartner extends Partner {

    public DeliveryPartner(String name) {
        super(name);
    }

    //perform Delivery
    void performDelivery(String orderId, DeliveryMetaData deliveryMetaData) {
        NotificationMgr notificationMgr = NotificationMgr.getInstance();
        double restaurantLocationLat = deliveryMetaData.getRestaurantLocation().getLatitude();
        double restaurantLocationLong = deliveryMetaData.getRestaurantLocation().getLongitude();
        notificationMgr.notify(orderId, name + " going to pick up delivery from location " + restaurantLocationLat + "," + restaurantLocationLong);
        Common.addDelay();
        notificationMgr.notify(orderId, name + " picked up delivery!");
        Common.addDelay();
        notificationMgr.notify(orderId, name + " order on the way!");
        Common.addDelay();
        double userLocationLat = deliveryMetaData.getDeliveryLocation().getLatitude();
        double userLocationLong = deliveryMetaData.getDeliveryLocation().getLongitude();
        notificationMgr.notify(orderId, name + " reached the Location " + userLocationLat + "," + userLocationLong);
        Common.addDelay();
        notificationMgr.notify(orderId, name + " order completed!");
    }
}
