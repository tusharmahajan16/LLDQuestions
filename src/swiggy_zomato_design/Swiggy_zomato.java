package swiggy_zomato_design;

import java.util.HashMap;
import java.util.List;

public class Swiggy_zomato {
    public static void main(String[] args) {
        //chinese restaurant
        RestaurantOwner restaurantOwner = new RestaurantOwner("owner1");
        Restaurant chineseRest = new Restaurant("Chowman", new Location(23, 45), restaurantOwner);
        Dish noodles = new Dish("Hakka noodles", Common.CUISINE.CHINESE, 200);
        noodles.addDishAddOn(new DishAddOn("Half chilly Paneer", 100));
        Dish friedRice = new Dish("Fried Rice", Common.CUISINE.CHINESE, 150);
        Dish paneerManchurian = new Dish("Paneer Manchurian", Common.CUISINE.CHINESE, 200);
        chineseRest.setMenu(new Menu(List.of(noodles, friedRice, paneerManchurian)));

        //NorthIndian Restaurant
        RestaurantOwner restaurantOwner2 = new RestaurantOwner("owner2");
        Restaurant northIndianRest = new Restaurant("Punjabi Rasoi", new Location(44, 67), restaurantOwner);
        Dish dalMaknni = new Dish("Dal Makhni", Common.CUISINE.CHINESE, 200);
        dalMaknni.addDishAddOn(new DishAddOn("Missi Roti", 45));
        Dish pannerTikka = new Dish("Paneer Tikka", Common.CUISINE.CHINESE, 250);
        Dish kajuMasala = new Dish("Kaju Masala", Common.CUISINE.CHINESE, 210);
        northIndianRest.setMenu(new Menu(List.of(dalMaknni, pannerTikka, kajuMasala)));

        //Note that restaurant owners can exist without restaurants, we have used aggregation relationship
        //This can lead to owners being present with no restaurants and thus not added in restaurant manager

        //adding Restaurants
        RestaurantMgr restaurantMgr = RestaurantMgr.getInstance();
        restaurantMgr.addRestaurant(chineseRest.getName(), chineseRest);
        restaurantMgr.addRestaurant(northIndianRest.getName(), northIndianRest);

        //adding Delivery Partners
        DeliveryPartner deliveryPartner = new DeliveryPartner("Ajay");
        DeliveryPartner deliveryPartner2 = new DeliveryPartner("Bob");
        DeliveryPartner deliveryPartner3 = new DeliveryPartner("Biscutt");
        DeliveryPartnerMgr deliveryPartnerMgr = DeliveryPartnerMgr.getInstance();
        deliveryPartnerMgr.addDeliveryPartner(deliveryPartner.getName(), deliveryPartner);
        deliveryPartnerMgr.addDeliveryPartner(deliveryPartner2.getName(), deliveryPartner2);
        deliveryPartnerMgr.addDeliveryPartner(deliveryPartner3.getName(), deliveryPartner3);

        //adding Users
        User user = new User("Tushar", new Location(30, 40));
        User user1 = new User("Chaska Maska", new Location(45, 50));
        User user2 = new User("Digestive", new Location(120, 150));
        UserMgr userMgr = UserMgr.getInstance();
        userMgr.addUser(user.getName(), user);
        userMgr.addUser(user1.getName(), user1);
        userMgr.addUser(user2.getName(), user2);

        //creating order
        HashMap<Dish, Integer> cart = new HashMap<>();
        cart.put(dalMaknni, 1);
        cart.put(kajuMasala, 2);
        Order order = new Order(user1, northIndianRest, cart);
        System.out.println("Total Price for the Order is : "+order.getTotalPrice());
        OrderMgr orderMgr = OrderMgr.getInstance();
        orderMgr.createOrder("order1", order);

    }
}
