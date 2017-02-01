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

    public static void traverseDirectory(int depth) {
        LinkedList<File> subFolders = new LinkedList<File>();

        String path = SessionData.currentPath;
        int initialIndentation = path.split("\\\\").length;

        File root = new File(path);

        subFolders.add(root);

        while (subFolders.size() != 0) {

            File currentFolder = subFolders.removeFirst();
            int currentIndentation = currentFolder.toString().split("\\\\"). length - initialIndentation;

            if (depth - currentIndentation < 0) {
                break;
            }

            OutputWriter.writeMessageOnNewLine(currentFolder.toString());

            try {

                if (currentFolder.listFiles() != null) {
                    for (File file : currentFolder.listFiles()) {
                        if (file.isDirectory()) {
                            subFolders.add(file);
                          //  subFolders.addAll(Arrays.asList(file.listFiles()));
                        } else {
                            int indexOfLastSlash = file.toString().lastIndexOf("\\");
                            for (int i = 0; i < indexOfLastSlash; i++) {
                                OutputWriter.writeMessage("-");
                            }

                            OutputWriter.writeMessageOnNewLine(file.getName());
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
