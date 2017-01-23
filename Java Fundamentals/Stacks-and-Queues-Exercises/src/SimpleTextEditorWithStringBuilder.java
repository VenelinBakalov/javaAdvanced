import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class SimpleTextEditorWithStringBuilder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int operationsCount = Integer.parseInt(scanner.nextLine());

        Deque<String> textContainer = new ArrayDeque<>();
        textContainer.push("");

        for (int i = 0; i < operationsCount; i++) {
            String[] commandLine = scanner.nextLine().split(" ");
            int commandType = Integer.parseInt(commandLine[0]);

            StringBuilder text = new StringBuilder();

            switch (commandType) {
                case 1:
                    String textToAppend = commandLine[1];
                    text = new StringBuilder(textContainer.peek());
                    text.append(textToAppend);
                    textContainer.push(text.toString());
                    break;
                case 2:
                    int eraseCount = Integer.parseInt(commandLine[1]);
                    text = new StringBuilder(textContainer.peek());
                    text = new StringBuilder(text.substring(0, text.length() - eraseCount));
                    textContainer.push(text.toString());
                    break;
                case 3:
                    int printPosition = Integer.parseInt(commandLine[1]) - 1;
                    text = new StringBuilder(textContainer.peek());
                    System.out.println(text.charAt(printPosition));
                    break;
                case 4:
                    textContainer.poll();
            }
        }
    }
}
