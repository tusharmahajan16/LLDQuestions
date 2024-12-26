package swiggy_zomato_design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

//observer pattern implementation
public class NotificationMgr {
    private static NotificationMgr instance;
    HashMap<String, List<Sender>> notificationSenderMap;

    private NotificationMgr() {
        notificationSenderMap = new HashMap<>();
    }

    public static NotificationMgr getInstance() {
        if (instance == null) {
            synchronized (NotificationMgr.class) {
                if (instance == null) {
                    instance = new NotificationMgr();
                }
            }
        }
        return instance;
    }

    //add observer
    void addNotificationSender(String orderId, String userId, NotificationSender notificationSender) {
        Sender sender = new Sender(userId, notificationSender);
        if (notificationSenderMap.containsKey(orderId)) {
            List<Sender> senderList = notificationSenderMap.get(orderId);
            boolean found = false;
            for (Sender s : senderList) {
                if (s.getUserId().equals(userId) && (s.getNotificationSender().equals(sender.getNotificationSender()) || s.getNotificationSender().getClass() == sender.getNotificationSender().getClass())) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                senderList.add(sender);
                notificationSenderMap.put(orderId, senderList);
            }
        } else {
            List<Sender> senderList = new ArrayList<>();
            senderList.add(sender);
            notificationSenderMap.put(orderId, senderList);
        }
    }

    //remove observer
    void removeNotificationSender(String orderId, String userId, NotificationSender notificationSender) {
        if (notificationSenderMap.containsKey(orderId)) {
            List<Sender> senderList = notificationSenderMap.get(orderId);
            Iterator<Sender> iterator = senderList.iterator();
            while (iterator.hasNext()) {
                Sender s = iterator.next();
                // Check if the userId matches and if the NotificationSender is either the same or of the same class
                if (s.getUserId().equals(userId) &&
                        (s.getNotificationSender().equals(notificationSender) || s.getNotificationSender().getClass() == notificationSender.getClass())) {
                    iterator.remove(); // Remove the matching Sender
                    break; // Exit the loop after removing
                }
            }
        }
    }

    //notify observers
    void notify(String orderId, String msg) {
        for (Sender s : notificationSenderMap.get(orderId)) {
            s.getNotificationSender().sendNotifications(orderId,"("+ s.getUserId()+") "+msg);
        }
    }

    //notify a particular user
    void notifyParticularUser(String userId, String msg, NotificationSender notificationSender) {
        notificationSender.sendNotifications(userId, msg);
    }
}
