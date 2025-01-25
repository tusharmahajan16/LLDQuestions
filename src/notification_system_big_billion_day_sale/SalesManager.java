package notification_system_big_billion_day_sale;

import notification_system_big_billion_day_sale.abstracts.Observer;
import notification_system_big_billion_day_sale.abstracts.Subject;

import java.util.ArrayList;
import java.util.List;

public class SalesManager implements Subject {
    List<Observer> observers;
    String sale;
    boolean saleIsActive;

    SalesManager() {
        observers = new ArrayList<>();
    }

    public void setSale(String sale, boolean saleIsActive) {
        this.sale = sale;
        this.saleIsActive = saleIsActive;
        notifyObservers();
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        if (sale != null && !sale.isBlank()) {
            for (Observer o : observers) {
                if (saleIsActive) {
                    o.update(sale + " Started");
                } else {
                    o.update(sale + " ended");
                }
            }
        }
    }
}
