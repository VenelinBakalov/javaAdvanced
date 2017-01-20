import java.io.File;
import java.util.LinkedList;

public class IOManager {

    public static void traverseDirectory(String path) {
        LinkedList<File> subFolders = new LinkedList<File>();
        File root = new File(path);

        subFolders.add(root);
    }
}
