package p01_system_resources;

import java.time.LocalTime;

/**
 * Created by Venelin on 6.4.2017 г..
 */
public class LocalTimeProvider implements TimeProvider {

    @Override
    public int getHour() {
        return LocalTime.now().getHour();
    }
}
