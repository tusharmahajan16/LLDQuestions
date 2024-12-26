package swiggy_zomato_design;

public class OrderMgr {
    private static OrderMgr instance;

    private OrderMgr() {
    }

    public static OrderMgr getInstance() {
        if (instance == null) {
            synchronized (OrderMgr.class) {
                if (instance == null) {
                    instance = new OrderMgr();
                }
            }
        }
        return instance;
    }

    public void createOrder(String orderId, Order order) {
        order.user.addUsersForNotifications(orderId);
        manageFood(orderId, order);
        manageDelivery(orderId, order);
    }

    void manageFood(String orderId, Order order) {
        FoodMgr foodMgr = FoodMgr.getInstance();
        foodMgr.prepareFood(orderId, order.getRestaurant().getName(), order.getDishes());
    }

    void manageDelivery(String orderId, Order order) {
        DeliveryMetaData deliveryMetaData = new DeliveryMetaData(orderId, order.getRestaurant().getLocation(), order.getUser().location);
        DeliveryMgr deliveryMgr = DeliveryMgr.getInstance();
        deliveryMgr.manageDelivery(orderId, deliveryMetaData);
    }
}
