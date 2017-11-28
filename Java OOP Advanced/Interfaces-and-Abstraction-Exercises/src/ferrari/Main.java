package ferrari;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.instrument.IllegalClassFormatException;

/**
 * Created by Venelin on 15.3.2017 г..
 */
public class Main {

    public static void main(String[] args) throws IOException, IllegalClassFormatException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String driver = reader.readLine();
        Ferrari ferrari = new Ferrari(driver);

        System.out.println(String.format("%s/%s/%s/%s", Ferrari.getModel(), ferrari.useBrakes(), ferrari.pushGash(), ferrari.getDriverName()));

        String ferrariName = Ferrari.class.getSimpleName();
        String carInterface = Car.class.getSimpleName();

        boolean isCreated = Car.class.isInterface();

        if (!isCreated) {
            throw new IllegalClassFormatException("No interface created!");
        }
    }
}
