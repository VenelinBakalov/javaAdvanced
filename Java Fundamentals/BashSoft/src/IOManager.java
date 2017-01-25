import java.io.File;
import java.util.Arrays;
import java.util.LinkedList;

public class IOManager {

    public static void main(String[] args) {
        traverseDirectory("C:\\Program Files");
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
