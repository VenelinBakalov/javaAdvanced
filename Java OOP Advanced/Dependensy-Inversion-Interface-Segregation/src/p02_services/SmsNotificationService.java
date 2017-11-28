package p02_services;

public class SmsNotificationService implements NotificationService {

    private boolean isActive;

    public SmsNotificationService(boolean isActive) {
        this.isActive = isActive;
    }

    public void sendNotification() {

    }

    public boolean isActive() {
        return this.isActive;
    }
}
