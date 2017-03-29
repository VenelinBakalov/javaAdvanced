package bg.softuni.io.commands;

import bg.softuni.exceptions.InvalidInputException;
import bg.softuni.io.IOManager;
import bg.softuni.io.OutputWriter;
import bg.softuni.judge.Tester;
import bg.softuni.network.DownloadManager;
import bg.softuni.repository.StudentsRepository;

public class GetHelpCommand extends Command {

    public GetHelpCommand(String input,
                          String[] data,
                          Tester tester,
                          StudentsRepository repository,
                          DownloadManager downloadManager,
                          IOManager ioManager) {
        super(input, data, tester, repository, downloadManager, ioManager);
    }

    @Override
    public void execute() throws Exception {
        String[] data = this.getData();
        if (data.length != 1) {
            throw new InvalidInputException(this.getInput());
        }

        displayHelp();
    }

    private void displayHelp() {
        StringBuilder helpBuilder = new StringBuilder();
        helpBuilder.append("make directory - mkdir nameOfFolder")
                .append(System.lineSeparator());
        helpBuilder.append("traverse directory - ls depth")
                .append(System.lineSeparator());
        helpBuilder.append("comparing files - cmp absolutePath1 absolutePath2")
                .append(System.lineSeparator());
        helpBuilder.append("change directory - cdRel relativePath or \"..\" for level up")
                .append(System.lineSeparator());
        helpBuilder.append("change directory - cdAbs absolutePath")
                .append(System.lineSeparator());
        helpBuilder.append("read students data base - readDb fileName")
                .append(System.lineSeparator());
        helpBuilder.append("filter students - filter {courseName} excellent/average/poor take 2/5/all")
                .append(System.lineSeparator());
        helpBuilder.append("order students - order {courseName} ascending/descending take 20/10/all")
                .append(System.lineSeparator());
        helpBuilder.append("download file - download URL (saved in current directory)")
                .append(System.lineSeparator());
        helpBuilder.append("download file on new thread - downloadAsynch URL (saved in the current directory)")
                .append(System.lineSeparator());
        helpBuilder.append("get help – help")
                .append(System.lineSeparator());
        OutputWriter.writeMessage(helpBuilder.toString());
        OutputWriter.writeEmptyLine();
    }
}
