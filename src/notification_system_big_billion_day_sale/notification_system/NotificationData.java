package notification_system_big_billion_day_sale.notification_system;

import notification_system_big_billion_day_sale.ObserverData;
import notification_system_big_billion_day_sale.abstracts.Observer;

public class NotificationData {
    private ObserverData observerData;
    private String message;
    public NotificationData(ObserverData observerData, String message) {
        this.observerData = observerData;
        this.message = message;
    }
    public ObserverData getObserverData() {
        return observerData;
    }

    public String getMessage() {
        return message;
    }
}
