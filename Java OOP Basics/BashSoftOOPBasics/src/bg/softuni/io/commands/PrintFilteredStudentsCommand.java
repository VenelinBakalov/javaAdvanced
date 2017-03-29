package bg.softuni.io.commands;

import bg.softuni.exceptions.InvalidInputException;
import bg.softuni.io.IOManager;
import bg.softuni.io.OutputWriter;
import bg.softuni.judge.Tester;
import bg.softuni.network.DownloadManager;
import bg.softuni.repository.StudentsRepository;
import bg.softuni.staticData.ExceptionMessages;

public class PrintFilteredStudentsCommand extends Command {

    public PrintFilteredStudentsCommand(String input,
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
        if (data.length != 5) {
            throw new InvalidInputException(this.getInput());
        }

        String course = data[1];
        String filter = data[2].toLowerCase();
        String takeCommand = data[3].toLowerCase();
        String takeQuantity = data[4].toLowerCase();

        this.tryParseParametersForFilter(takeCommand, takeQuantity, course, filter);
    }

    private void tryParseParametersForFilter(
            String takeCommand, String takeQuantity,
            String courseName, String filter) {
        if (!takeCommand.equals("take")) {
            OutputWriter.displayException(ExceptionMessages.INVALID_TAKE_COMMAND);
            return;
        }

        if (takeQuantity.equals("all")) {
            this.getRepository().filterAndTake(courseName, filter);
            return;
        }

        try {
            int studentsToTake = Integer.parseInt(takeQuantity);
            this.getRepository().filterAndTake(courseName, filter, studentsToTake);
        } catch (NumberFormatException nfe) {
            OutputWriter.displayException(ExceptionMessages.IVALID_TAKE_QUANTITY_PARAMETER);
        }
    }
}
