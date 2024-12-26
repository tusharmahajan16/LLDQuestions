package swiggy_zomato_design;

import java.util.ArrayList;

public class Dish {
    String name;
    Common.CUISINE cuisine;
    String description;
    ArrayList<DishAddOn> dishAddOns;
    double price;

    public Dish(String name, Common.CUISINE cuisine, double price) {
        this.name = name;
        this.cuisine = cuisine;
        this.price = price;
        dishAddOns = new ArrayList<>();
    }

    public void addDishAddOn(DishAddOn addOn) {
        dishAddOns.add(addOn);
    }

    public double getPrice() {
        double addOnsPrice = 0;
        for (DishAddOn addOn : dishAddOns) {
            addOnsPrice += addOn.getPrice();
        }
        return addOnsPrice + price;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public Common.CUISINE getCuisine() {
        return cuisine;
    }
}
