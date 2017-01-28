import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;

public class WriteToAFile {
    public static void main(String[] args) {
        String inputPath = "D:\\Venelin\\javaAdvanced\\Java Fundamentals\\Files-and-Streams-Lab\\05. Java-Advanced-Files-and-Directories-Lab-Resources\\input.txt";
        String outputPath = "D:\\Venelin\\javaAdvanced\\Java Fundamentals\\Files-and-Streams-Lab\\05. Java-Advanced-Files-and-Directories-Lab-Resources\\output.txt";

        try (FileInputStream fis = new FileInputStream(inputPath);
             FileOutputStream fos = new FileOutputStream(outputPath)){

            HashSet<Character> punctuation = new HashSet<>();
            Collections.addAll(punctuation, ',', '.', '!', '?');

            int oneByte = fis.read();

            while (oneByte >= 0) {
                if (!punctuation.contains((char)oneByte)) {
                    fos.write(oneByte);
                }
                oneByte = fis.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
