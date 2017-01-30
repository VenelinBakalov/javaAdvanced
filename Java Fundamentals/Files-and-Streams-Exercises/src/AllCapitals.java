import java.io.*;

public class AllCapitals {
    private final static String inputPath = "/src/resources/thirdTaskInput.txt";
    private final static String outputPath = "/src/resources/thirdTaskOutput.txt";

    public static void main(String[] args) throws FileNotFoundException {
        String projectPath = System.getProperty("user.dir");
        String filePath = projectPath + inputPath;
        String outputFilePath = projectPath + outputPath;

        File taskFile = new File(filePath);
        FileReader fileReader = new FileReader(taskFile);

        try (BufferedReader reader = new BufferedReader(fileReader);
        PrintWriter writer = new PrintWriter(outputFilePath)) {
            String line;

            while ((line = reader.readLine()) != null) {
                writer.println(line.toUpperCase());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
