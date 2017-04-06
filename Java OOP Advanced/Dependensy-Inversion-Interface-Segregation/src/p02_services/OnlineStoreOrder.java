package p02_services;

public class OnlineStoreOrder {

    private EmailNotificationService emailNotification;
    private SmsNotificationService smsNotification;

    public OnlineStoreOrder(EmailNotificationService emailNotificationService, SmsNotificationService smsNotificationService) {
        this.emailNotification = emailNotificationService;
        this.smsNotification = smsNotificationService;
    }

    public void process() {
        if (this.smsNotification.isActive())
            this.smsNotification.sendNotification();

        if (this.emailNotification.isActive())
            this.smsNotification.sendNotification();
    }
}
