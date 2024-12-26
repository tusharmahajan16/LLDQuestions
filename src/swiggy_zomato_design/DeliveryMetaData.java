package swiggy_zomato_design;

public class DeliveryMetaData {
    String orderId;
    Location restaurantLocation;
    Location deliveryLocation;

    public DeliveryMetaData(String orderId, Location restaurantLocation, Location deliveryLocation) {
        this.orderId = orderId;
        this.restaurantLocation = restaurantLocation;
        this.deliveryLocation = deliveryLocation;
    }

    public String getOrderId() {
        return orderId;
    }

    public Location getRestaurantLocation() {
        return restaurantLocation;
    }

    public Location getDeliveryLocation() {
        return deliveryLocation;
    }
}
