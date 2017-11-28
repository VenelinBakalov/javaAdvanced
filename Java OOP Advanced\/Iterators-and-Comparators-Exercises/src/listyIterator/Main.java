package listyIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Created by Venelin on 22.3.2017 г..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String command = reader.readLine();
        List<String> iterArgs = Arrays.stream(command.split(" ")).skip(1).collect(Collectors.toList());
        ListyIterator iterator = new ListyIterator(iterArgs);
        while (!"END".equals(command = reader.readLine())) {
            try {
                switch (command) {
                    case "Move":
                        System.out.println(iterator.move());
                        break;
                    case "HasNext":
                        System.out.println(iterator.hasNext());
                        break;
                    case "Print":
                        iterator.print();
                        break;
                    case "PrintAll":
                        iterator.printAll();
                        break;
                }
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
