package classBox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        Class boxClass = Box.class;
        Field[] fields = boxClass.getDeclaredFields();
        System.out.println(Arrays.stream(fields)
                .filter(f -> Modifier.isPrivate(f.getModifiers())).count());
                */
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Double length = Double.parseDouble(reader.readLine());
        Double width = Double.parseDouble(reader.readLine());
        Double height = Double.parseDouble(reader.readLine());

        Box box = null;

        try {
            box = new Box(length, width, height);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
            return;
        }

        System.out.println(String.format("Surface Area - %.2f", box.getSurfaceArea()));
        System.out.println(String.format("Lateral Surface Area - %.2f", box.getLateralSurfaceArea()));
        System.out.println(String.format("Volume - %.2f", box.getVolume()));
    }
}
