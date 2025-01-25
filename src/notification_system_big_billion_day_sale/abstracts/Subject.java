package notification_system_big_billion_day_sale.abstracts;


public interface Subject {
    void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}
