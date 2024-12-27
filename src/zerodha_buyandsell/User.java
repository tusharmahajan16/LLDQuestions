package zerodha_buyandsell;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class User {
    private String name;
    double funds;
    List<Stock> watchList;
    HashMap<String,Order> portFolio;

    public User(String name) {
        this.name = name;
        funds = 0;
        portFolio = new HashMap<>();
        watchList = new ArrayList<>();
    }

    public Order getAvailableStocks(String stockName) {
        return portFolio.get(stockName);
    }

    public double getFunds() {
        return funds;
    }
    public String getName() {
        return name;
    }

    public void setFunds(double funds) {
        this.funds = funds;
    }
}
