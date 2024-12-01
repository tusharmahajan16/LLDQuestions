package vendingmachine;

public enum ItemType {
    COKE(10),
    PEPSI(12),
    SODA(20);
    private final int price;
    ItemType(int price) {
        this.price = price;
    }
    public int getPrice() {return price;}
}
