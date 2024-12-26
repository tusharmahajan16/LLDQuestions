package swiggy_zomato_design;

public class DishAddOn {
    private String name;
    private String description;
    private boolean isAvailable;
    private double price;

    public DishAddOn(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
