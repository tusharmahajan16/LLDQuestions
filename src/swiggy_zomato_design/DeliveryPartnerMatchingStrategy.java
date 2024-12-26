package swiggy_zomato_design;

import java.util.List;

public interface DeliveryPartnerMatchingStrategy {
    List<DeliveryPartner> matchDeliveryPartner(DeliveryMetaData deliveryMetaData);
}
