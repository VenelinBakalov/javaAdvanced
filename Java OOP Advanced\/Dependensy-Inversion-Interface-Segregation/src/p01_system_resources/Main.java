package p01_system_resources;

/**
 * Created by Venelin on 6.4.2017 г..
 */
public class Main {
    public static void main(String[] args) {
        GreetingClock clock = new GreetingClock(new LocalTimeProvider(), new ConsoleWriter());
        clock.greeting();
    }
}
