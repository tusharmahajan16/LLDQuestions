package notification_system_big_billion_day_sale;

import notification_system_big_billion_day_sale.abstracts.Observer;
import notification_system_big_billion_day_sale.notification_system.BaseNotificationChannel;
import notification_system_big_billion_day_sale.notification_system.EmailDecorator;
import notification_system_big_billion_day_sale.notification_system.NotificationChannel;
import notification_system_big_billion_day_sale.notification_system.SMSDecorator;

public class Main {
    public static void main(String[] args) {
        SalesManager salesManager = new SalesManager();
        Observer user1 = new User(new ObserverData("101","Tushar","tusharmahajan2403@gmail.com","777777777"));
        Observer user2 =  new Admin(new ObserverData("101","Adam","adam101@gmail.com","111111111"));
        NotificationChannel notificationChannel1 = new SMSDecorator(new EmailDecorator(new BaseNotificationChannel()));
        NotificationChannel notificationChannel2 = new EmailDecorator(new BaseNotificationChannel());
        user1.getObserverData().setSubscribedNotificationChannel(notificationChannel1);
        user2.getObserverData().setSubscribedNotificationChannel(notificationChannel2);
        salesManager.addObserver(user1);
        salesManager.addObserver(user2);
        salesManager.setSale("Big Billion Day Sale",true);
        salesManager.setSale("Big Billion Day Sale",false);

    }
}
