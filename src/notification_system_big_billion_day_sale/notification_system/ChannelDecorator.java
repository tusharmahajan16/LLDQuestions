package notification_system_big_billion_day_sale.notification_system;

public class ChannelDecorator implements NotificationChannel {
    private NotificationChannel wrappedChannel;
    public ChannelDecorator(NotificationChannel wrappedChannel) {
        this.wrappedChannel = wrappedChannel;
    }
    @Override
    public void sendNotification(NotificationData notificationData) {
        wrappedChannel.sendNotification(notificationData);
    }
}
