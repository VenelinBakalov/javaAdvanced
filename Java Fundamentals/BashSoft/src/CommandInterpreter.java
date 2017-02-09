import java.awt.*;
import java.io.File;
import java.io.IOException;

public class CommandInterpreter {

    public static void interpretCommand(String input) {
        String[] data = input.split("\\s+");
        String command = data[0];

        switch (command) {
            case "open":
                tryOpenFile(input, data);
                break;
            case "mkdir":
                tryCreateDirectory(input, data);
                break;
            case "Is":
                tryTraverseFolders(input, data);
                break;
            case "cmp":
                tryCompareFiles(data[1], data[2]);
                break;
            case "changeDirRel":
                changeCurrentDirectoryByRelativePath(data[1]);
                break;
            case "changeDirAbs":
                changeCurrentDirectoryByAbsolutePath(data[1]);
                break;
            case "readDb":
                readStudentsDataBase(data[1]);
                break;
            case "filter":
                filterStudents(data);
                break;
            case "order":
                orderStudents(data);
                break;
            case "download":
                downloadFile(data[1]);
                break;
            case "downloadAsynch":
                downloadFileAsynchronously(data[1]);
                break;
            case "help":
                getHelp();
                break;

            default:
                displayInvalidCommandMessage(input);
                break;
        }
    }

    private static void displayInvalidCommandMessage(String input) {
        String output = String.format("The command '%s' is invalid", input);
        OutputWriter.writeMessageOnNewLine(output);
    }

    private static void tryOpenFile(String input, String[] data) {
        if (data.length != 2) {
            displayInvalidCommandMessage(input);
            return;
        }

        String fileName = data[1];
        String filePath = SessionData.currentPath + "\\" + fileName;
        File file = new File(filePath);
        try {
            Desktop.getDesktop().open(file);
        } catch (IOException e) {
            OutputWriter.displayException(ExceptionMessages.UNABLE_TO_OPEN_FILE);
        }
    }

    private static void tryCreateDirectory(String input, String[] data) {
        if (data.length != 2) {
            displayInvalidCommandMessage(input);
            return;
        }

        String folderName = data[1];
        IOManager.createDirectoryInCurrentFolder(folderName);
    }

    private static void tryTraverseFolders(String input, String[] data) {
        if (data.length != 1 && data.length != 2) {
            displayInvalidCommandMessage(input);
            return;
        }

        if (data.length == 1) {
            IOManager.traverseDirectory(0);
        }

        if (data.length == 2) {
            IOManager.traverseDirectory(Integer.parseInt(data[1]));
        }
    }
}
