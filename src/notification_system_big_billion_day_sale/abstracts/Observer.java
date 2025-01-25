package notification_system_big_billion_day_sale.abstracts;

import notification_system_big_billion_day_sale.ObserverData;

public interface Observer {
    void update(String message);
    ObserverData getObserverData();
}
