import java.io.*;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) {
        String inputPath = "D:\\Venelin\\javaAdvanced\\Java Fundamentals\\Files-and-Streams-Lab\\05. Java-Advanced-Files-and-Directories-Lab-Resources\\input.txt";
        String outputPath = "D:\\Venelin\\javaAdvanced\\Java Fundamentals\\Files-and-Streams-Lab\\05. Java-Advanced-Files-and-Directories-Lab-Resources\\outputTaskThree.txt";

        try (Scanner scanner = new Scanner(new FileInputStream(inputPath));
             PrintWriter writer = new PrintWriter(outputPath)) {
            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    writer.println(scanner.nextInt());
                }

                scanner.next();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
