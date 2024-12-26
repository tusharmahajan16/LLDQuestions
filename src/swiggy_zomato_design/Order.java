package swiggy_zomato_design;

import java.util.HashMap;
import java.util.Map;

public class Order {
    User user;
    Restaurant restaurant;
    HashMap<Dish, Integer> dishes;
    Common.ORDER_STATUS status;
    String discountCode;
    String paymentId;
    double totalPrice;

    Order(User user, Restaurant restaurant, HashMap<Dish, Integer> dishes) {
        this.user = user;
        this.restaurant = restaurant;
        this.dishes = dishes;
    }

    public User getUser() {
        return user;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public HashMap<Dish, Integer> getDishes() {
        return dishes;
    }

    public double getTotalPrice() {
        for (Map.Entry<Dish, Integer> dishEntry : dishes.entrySet()) {
            totalPrice += dishEntry.getKey().getPrice() * dishEntry.getValue();
        }
        return totalPrice;
    }
}
