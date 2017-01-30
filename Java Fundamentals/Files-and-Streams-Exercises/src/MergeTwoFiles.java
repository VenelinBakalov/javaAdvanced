import java.io.*;

public class MergeTwoFiles {
    private static final String PROJECT_PATH = System.getProperty("user.dir") + "/src/resources/";
    private static final String FIRST_INPUT_FILE = PROJECT_PATH + "firstInputFile.txt";
    private static final String SECOND_INPUT_FILE = PROJECT_PATH + "secondInputFile.txt";
    private static final String OUTPUT_FILE_PATH = PROJECT_PATH + "outputTaskSeven.txt";

    public static void main(String[] args) {

        try (BufferedReader firstFileReader = new BufferedReader(new FileReader(FIRST_INPUT_FILE));
        BufferedReader secondFileReader = new BufferedReader(new FileReader(SECOND_INPUT_FILE));
             PrintWriter writer = new PrintWriter(new FileWriter(OUTPUT_FILE_PATH, true))) {

            String line = "";

            while ((line = firstFileReader.readLine()) != null) {
                writer.println(line);
            }
            while ((line = secondFileReader.readLine()) != null) {
                writer.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
