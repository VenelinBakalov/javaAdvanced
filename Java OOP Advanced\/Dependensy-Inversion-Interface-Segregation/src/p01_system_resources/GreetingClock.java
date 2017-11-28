package p01_system_resources;

public class GreetingClock {
    private static final String GOOD_MORNING_MESSAGE = "Good morning...";
    private static final String GOOD_AFTERNOON_MESSAGE = "Good afternoon...";
    private static final String GOOD_EVENING_MESSAGE = "Good evening...";

    private TimeProvider timeProvider;
    private Writer writer;

    public GreetingClock(TimeProvider timeProvider, Writer writer) {
        this.timeProvider = timeProvider;
        this.writer = writer;
    }

    public void greeting() {
        if (this.timeProvider.getHour() < 12) {
           this.writer.write(GOOD_MORNING_MESSAGE);
        } else if (this.timeProvider.getHour() < 18) {
            this.writer.write(GOOD_AFTERNOON_MESSAGE);
        } else {
            this.writer.write(GOOD_EVENING_MESSAGE);
        }
    }
}
