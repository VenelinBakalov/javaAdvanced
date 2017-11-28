package weekdays;

/**
 * Created by Venelin on 23.3.2017 г..
 */
public class Main {
    public static void main(String[] args) {
        WeeklyCalendar calendar = new WeeklyCalendar();
        calendar.addEntry("Friday", "sleep");
        calendar.addEntry("Monday", "sport");
        Iterable<WeeklyEntry> schedule = calendar.getWeeklySchedule();
        for (WeeklyEntry entry : schedule) {
            System.out.println(entry);
        }
    }
}
