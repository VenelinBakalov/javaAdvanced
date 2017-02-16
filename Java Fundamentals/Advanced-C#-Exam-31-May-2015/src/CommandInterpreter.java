import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.Collator;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CommandInterpreter {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> list = Stream.of(reader.readLine().trim().split("\\s+")).collect(Collectors.toList());
        String input;
        while (!"end".equals(input = reader.readLine())) {
            String[] commandsArgs = input.split("\\s+");
            String command = commandsArgs[0];
            int start, count;
            List<String> subList;

            switch (command) {

                case "reverse":
                    start = Integer.parseInt(commandsArgs[2]);
                    count = Integer.parseInt(commandsArgs[4]);

                    if (start < 0
                            || count < 0
                            || start >= list.size()
                            || (start + count) > list.size()) {
                        System.out.println("Invalid input parameters.");
                        break;
                    }

                    subList = list.stream()
                            .skip(start).limit(count)
                            .collect(Collectors.toList());

                    for (int i = 0; i < count; i++) {
                        list.remove(start);
                    }

                    Collections.reverse(subList);

                    list.addAll(start, subList);
                    break;

                case "sort":
                    start = Integer.parseInt(commandsArgs[2]);
                    count = Integer.parseInt(commandsArgs[4]);

                    if (start < 0
                            || count < 0
                            || start >= list.size()
                            || (start + count) > list.size()) {
                        System.out.println("Invalid input parameters.");
                        break;
                    }

                    subList = list.stream()
                            .skip(start).limit(count)
                            .collect(Collectors.toList());

                    for (int i = 0; i < count; i++) {
                        list.remove(start);
                    }

                    Collections.sort(subList, Collator.getInstance(Locale.ENGLISH));
                    list.addAll(start, subList);
                    break;

                case "rollLeft":
                    count = Integer.parseInt(commandsArgs[1]) % list.size();

                    if (count < 0) {
                        System.out.println("Invalid input parameters.");
                        break;
                    }

                    for (int i = 0; i < count; i++) {
                        String leftmostElement = list.get(0);
                        list.remove(0);
                        list.add(leftmostElement);
                    }
                    break;

                case "rollRight":
                    count = Integer.parseInt(commandsArgs[1]) % list.size();

                    if (count < 0) {
                        System.out.println("Invalid input parameters.");
                        break;
                    }

                    for (int i = 0; i < count; i++) {
                        String rightmostElement = list.get(list.size() - 1);
                        list.remove(list.size() - 1);
                        list.add(0, rightmostElement);
                    }
                    break;

                default:
                    break;
            }
        }
        System.out.println(String.format("[%s]", String.join(", ", list)));
    }
}
