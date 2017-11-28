package p02_services;

public class OnlineStoreOrder {

    private NotificationService notificationService;

    public OnlineStoreOrder(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void process() {
        if (this.notificationService.isActive()) {
            this.notificationService.sendNotification();
        }
    }
}
