package swiggy_zomato_design;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LocationBasedDeliveryPartnerMatching implements DeliveryPartnerMatchingStrategy {
    @Override
    public List<DeliveryPartner> matchDeliveryPartner(DeliveryMetaData deliveryMetaData) {
        DeliveryPartnerMgr deliveryPartnerMgr = DeliveryPartnerMgr.getInstance();
        System.out.println("Quadtrees can be used to get nearest delivery partners, "+
                "Delivery partner manager can be used to get details of partners. "+
                "Returning all delivery partners for demo purposes for now.");
        List<DeliveryPartner> deliveryPartners = new ArrayList<>();
        for (Map.Entry<String, DeliveryPartner> deliveryPartnerEntry : deliveryPartnerMgr.getDeliveryPartners().entrySet()) {
            deliveryPartners.add(deliveryPartnerEntry.getValue());
        }
        return deliveryPartners;
    }
}
