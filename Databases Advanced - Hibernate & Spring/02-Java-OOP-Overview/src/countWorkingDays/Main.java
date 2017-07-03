package countWorkingDays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Venelin on 4.7.2017 г..
 */
public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstDate = reader.readLine();
        String secondDate = reader.readLine();

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date startDate = sdf.parse(firstDate);
        Date endDate = sdf.parse(secondDate);

        Date[] holidays = {
                sdf.parse("01-01-2000"),
                sdf.parse("03-03-2000"),
                sdf.parse("01-05-2000"),
                sdf.parse("06-05-2000"),
                sdf.parse("24-05-2000"),
                sdf.parse("06-09-2000"),
                sdf.parse("22-09-2000"),
                sdf.parse("01-11-2000"),
                sdf.parse("24-12-2000"),
                sdf.parse("25-12-2000"),
                sdf.parse("26-12-2000")
        };

        Date currentDate = new Date();

        Calendar calendar = Calendar.getInstance();
        int workingDays = 0;

        for (long i = startDate.getTime(); i <= endDate.getTime(); i = startDate.getTime()) {
            boolean isNotWorkingDay = false;
            calendar.setTime(startDate);

            if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY ||
                    calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY ) {
                isNotWorkingDay = true;
            }

            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DATE);

            calendar.clear();
            calendar.set(2000, month, day);

            currentDate.setTime(calendar.getTimeInMillis());

            if (! isNotWorkingDay && ! Arrays.asList(holidays).contains(currentDate)) {
                workingDays++;
            }

            startDate.setTime(startDate.getTime() + 1000 * 60 * 60 * 24);
        }

        System.out.println(workingDays);
    }
}
