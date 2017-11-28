package harvestingFields;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Venelin on 29.3.2017 г..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Class richSoilClass = RichSoilLand.class;
        List<Field> fields = Arrays.asList(richSoilClass.getDeclaredFields());
        List<Field> privateFields = fields.stream().
                filter(f -> Modifier.isPrivate(f.getModifiers()))
                .collect(Collectors.toList());
        List<Field> protectedFields = fields.stream()
                .filter(f -> Modifier.isProtected(f.getModifiers()))
                .collect(Collectors.toList());
        List<Field> publicFields = fields.stream()
                .filter(f -> Modifier.isPublic(f.getModifiers()))
                .collect(Collectors.toList());

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String command;

        while (!"HARVEST".equals(command = reader.readLine())) {
            switch (command) {
                case "all":
                    executePrintCommand(fields);
                    break;
                case "private":
                    executePrintCommand(privateFields);
                    break;
                case "protected":
                    executePrintCommand(protectedFields);
                    break;
                case "public":
                    executePrintCommand(publicFields);
                    break;
            }
        }
    }

    private static void executePrintCommand(List<Field> fields) {
        for (Field field : fields) {
            System.out.println(String.format("%s %s %s", Modifier.toString(field.getModifiers()),
                    field.getType().getSimpleName(), field.getName()));
        }
    }
}
