package zerodha_buyandsell;

public class Stock {
    private String name;
    private double price;
    private Common.EXCHANGE exchange;

    public Stock(String name, double price, Common.EXCHANGE exchange) {
        this.name = name;
        this.price = price;
        this.exchange = exchange;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
