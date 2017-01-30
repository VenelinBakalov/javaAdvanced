import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class GetFolderSize {
    private static final String PROJECT_PATH = System.getProperty("user.dir");
    private static final String OUTPUT_PATH = PROJECT_PATH + "/src/resources/outputTaskEight.txt";

    public static void main(String[] args) {
        Deque<File> files = new ArrayDeque<>();
        File projectFolder = new File(PROJECT_PATH);
        files.add(projectFolder);
        int folderSize = 0;

        while (!files.isEmpty()) {
            File currentFolder = files.poll();

            if (currentFolder.isDirectory()) {
                File[] currentFiles = currentFolder.listFiles();
                for (File currentFile : currentFiles) {
                    if (!currentFile.isDirectory()) {
                        folderSize += currentFile.length();
                    } else {
                        files.offer(currentFile);
                    }
                }
            } else {
                folderSize += currentFolder.length();
            }
        }

        try (PrintWriter writer = new PrintWriter(OUTPUT_PATH)) {
            writer.println("Folder size: " + folderSize);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
