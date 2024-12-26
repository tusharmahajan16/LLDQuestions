package swiggy_zomato_design;

import java.util.HashMap;

public class FoodMgr {
    private static FoodMgr instance;

    private FoodMgr() {
    }

    public static FoodMgr getInstance() {
        if (instance == null) {
            synchronized (FoodMgr.class) {
                if (instance == null) {
                    instance = new FoodMgr();
                }
            }
        }
        return instance;
    }

    void prepareFood(String orderId, String restaurantId, HashMap<Dish,Integer> dishes) {
        RestaurantMgr restaurantMgr = RestaurantMgr.getInstance();
        Restaurant restaurant = restaurantMgr.getRestaurant(restaurantId);
        restaurant.prepareFood(orderId, dishes);
        //Restaurant should receive the delivery partner's notifications.
        //The order in which the restaurant, user & delivery partner are added to the notification mgr
        //will decide which notifications they receive
        //For interviews, This is too much detailing though, we can just mention to interviewer and move forward
        restaurant.addRestaurantForNotifications(orderId);
    }
}
