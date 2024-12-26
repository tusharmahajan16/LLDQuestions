package swiggy_zomato_design;

import java.util.List;

public class DeliveryMgr {
    private static DeliveryMgr instance;

    private DeliveryMgr() {
    }

    public static DeliveryMgr getInstance() {
        if (instance == null) {
            synchronized (UserMgr.class) {
                if (instance == null) {
                    instance = new DeliveryMgr();
                }
            }
        }
        return instance;
    }

    void manageDelivery(String orderId, DeliveryMetaData deliveryMetaData) {
        StrategyMgr strategyMgr = StrategyMgr.getInstance();
        DeliveryPartnerMatchingStrategy deliveryPartnerMatchingStrategy = strategyMgr.determineDeliveryPartnerMatchingStrategy(deliveryMetaData);
        List<DeliveryPartner> deliveryPartners = deliveryPartnerMatchingStrategy.matchDeliveryPartner(deliveryMetaData);
        NotificationMgr notificationMgr = NotificationMgr.getInstance();
        // notifying Delivery partners for order
        for (DeliveryPartner deliveryPartner : deliveryPartners) {
            notificationMgr.notifyParticularUser(deliveryPartner.getName(), "Delivery Request", new PushNotification());
        }

        DeliveryPartner assignedDeliveryPartner = deliveryPartners.getFirst();
        //Assume first delivery partner accepted it
        notificationMgr.notify(orderId, "Delivery Partner " + assignedDeliveryPartner.getName() + " assigned for the order " + orderId);
        assignedDeliveryPartner.performDelivery(orderId, deliveryMetaData);
    }
}
