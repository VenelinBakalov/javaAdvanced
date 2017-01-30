import java.io.*;

public class LineNumbers {
    private final static String inputPath = "/src/resources/fifthTaskInput.txt";
    private final static String outputPath = "/src/resources/fifthTaskOutput.txt";

    public static void main(String[] args) throws FileNotFoundException {
        String projectPath = System.getProperty("user.dir");
        String filePath = projectPath + inputPath;
        String outputFilePath = projectPath + outputPath;
        File taskFile = new File(filePath);
        FileReader fileReader = new FileReader(taskFile);

        try (BufferedReader reader = new BufferedReader(fileReader);
            PrintWriter writer = new PrintWriter(outputFilePath)) {
            String line;
            int lineCount = 0;

            while ((line = reader.readLine()) != null) {
                lineCount++;
                writer.println(lineCount + ". " + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
