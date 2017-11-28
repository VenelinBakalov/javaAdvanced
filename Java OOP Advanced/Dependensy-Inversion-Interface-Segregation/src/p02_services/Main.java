package p02_services;

/**
 * Created by Venelin on 7.4.2017 г..
 */
public class Main {

    public static void main(String[] args) {

        CompositeNotificationService service = new CompositeNotificationService(true, new EmailNotificationService(true));
        OnlineStoreOrder order = new OnlineStoreOrder(service);
    }
}
