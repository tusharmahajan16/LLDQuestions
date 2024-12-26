package swiggy_zomato_design;

import java.util.HashMap;

public class DeliveryPartnerMgr {
    HashMap<String, DeliveryPartner> deliveryPartners;
    private static DeliveryPartnerMgr instance;
    private DeliveryPartnerMgr() {
        deliveryPartners = new HashMap<>();
    }
    public static DeliveryPartnerMgr getInstance() {
        if (instance == null) {
            synchronized (DeliveryPartnerMgr.class) {
                if (instance == null) {
                    instance = new DeliveryPartnerMgr();
                }
            }
        }
        return instance;
    }
    public void addDeliveryPartner(String DeliverPartnerName,DeliveryPartner partner) {
        deliveryPartners.put(DeliverPartnerName, partner);
    }
    public DeliveryPartner getDeliveryPartner(String DeliverPartnerName) {
        return deliveryPartners.get(DeliverPartnerName);
    }

    public HashMap<String, DeliveryPartner> getDeliveryPartners() {
        return deliveryPartners;
    }
}
