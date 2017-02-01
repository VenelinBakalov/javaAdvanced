import java.io.File;
import java.util.Arrays;
import java.util.LinkedList;

public class IOManager {

    public static void createDirectoryInCurrentFolder(String name) {

        String path = getCurrentDirectoryPath() + "\\" + name;
        File file = new File(path);
        file.mkdir();
    }

    private static String getCurrentDirectoryPath() {
        String currentPath = SessionData.currentPath;
        return currentPath;
    }

    public static void traverseDirectory(String path) {
        LinkedList<File> subFolders = new LinkedList<File>();
        File root = new File(path);

        subFolders.add(root);

        while (subFolders.size() != 0) {
            File currentFolder = subFolders.removeFirst();

            try {

                if (currentFolder.listFiles() != null) {
                    for (File file : currentFolder.listFiles()) {
                        if (file.isDirectory()) {
                            subFolders.addAll(Arrays.asList(file.listFiles()));
                        }
                    }
                }

                System.out.println(currentFolder.toString());
            } catch (Exception err) {
                System.out.println("Access denied");
            }
        }
    }
}
