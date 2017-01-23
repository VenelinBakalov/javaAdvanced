import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int operationsCount = Integer.parseInt(scanner.nextLine());

        Deque<Character> text = new ArrayDeque<>();
        Deque<String[]> commandsExecuted = new ArrayDeque<>();
        Deque<Character> erasedChars = new ArrayDeque<>();

        for (int i = 0; i < operationsCount; i++) {
            String[] commandLine = scanner.nextLine().split(" ");
            int commandType = Integer.parseInt(commandLine[0]);

            switch (commandType){
                case 1:
                    char[] textToAppend = commandLine[1].toCharArray();
                    for (int j = 0; j < textToAppend.length; j++) {
                        text.push(textToAppend[j]);
                    }
                    commandsExecuted.push(commandLine);
                    break;
                case 2:
                    int eraseCount = Integer.parseInt(commandLine[1]);
                    for (int j = 0; j < eraseCount; j++) {
                        erasedChars.push(text.poll());
                    }
                    commandsExecuted.push(commandLine);
                    break;
                case 3:
                    int printPosition = Integer.parseInt(commandLine[1]);
                    String[] currentText = text.toString().split("\\[|, |\\]", -1);

                    System.out.println(currentText[currentText.length - 1 - printPosition]);
                    break;
                case 4:
                    String[] previousCommand = commandsExecuted.poll();
                    String previousCommandType = previousCommand[0];
                    switch (previousCommandType){
                        case "1":
                            for (int j = 0; j < previousCommand[1].length(); j++) {
                                text.poll();
                            }
                            break;
                        case "2":
                            int returnCount = Integer.parseInt(previousCommand[1]);

                            for (int j = 0; j < returnCount; j++) {
                                text.push(erasedChars.poll());
                            }
                            break;
                    }

            }

        }
    }
}
