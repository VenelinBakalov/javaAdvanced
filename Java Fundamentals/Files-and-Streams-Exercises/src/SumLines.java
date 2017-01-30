import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SumLines {
    private final static String path = "/src/resources/firstTaskInput.txt";
    public static void main(String[] args) throws FileNotFoundException {
        // Returns project path!!!! Where the Files-and-Streams-Exercises folder is located on user's system!!!
        String projectPath = System.getProperty("user.dir");
        String filePath = projectPath + path;

        File someFile = new File(filePath);

        FileReader fileReader = new FileReader(someFile);


        try (BufferedReader reader = new BufferedReader(fileReader)){
            String line;

            while ((line = reader.readLine()) != null) {
                long sum = 0;
                for (char c : line.toCharArray()) {
                    sum += c;
                }
                System.out.println(sum);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


   //  try (BufferedReader reader1 = Files.newBufferedReader(Paths.get(inputPath))) {
   //      String line = reader.readLine();

   //      while (line != null) {
   //          int sum = 0;
   //          for (char character : line.toCharArray()) {
   //              sum += character;
   //          }

   //          System.out.println(sum);
   //          line = reader.readLine();
   //      }
   //  } catch (IOException e) {
   //      e.printStackTrace();
   //  }
    }
}
