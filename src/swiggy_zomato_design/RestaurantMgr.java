package swiggy_zomato_design;

import java.util.HashMap;

public class RestaurantMgr {
    private static RestaurantMgr instance;
    HashMap<String, Restaurant> restaurants;

    private RestaurantMgr() {
        restaurants = new HashMap<>();
    }

    public static RestaurantMgr getInstance() {
        if (instance == null) {
            synchronized (RestaurantMgr.class) {
                if (instance == null) {
                    instance = new RestaurantMgr();
                }
            }
        }
        return instance;
    }

    public HashMap<String, Restaurant> getRestaurants() {
        return restaurants;
    }

    public void addRestaurant(String restaurantName, Restaurant r) {
        restaurants.put(restaurantName, r);
    }

    public Restaurant getRestaurant(String restaurantName) {
        return restaurants.get(restaurantName);
    }
}
