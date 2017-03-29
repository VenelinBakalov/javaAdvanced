package bg.softuni.io.commands;

import bg.softuni.exceptions.InvalidInputException;
import bg.softuni.io.IOManager;
import bg.softuni.judge.Tester;
import bg.softuni.network.DownloadManager;
import bg.softuni.repository.StudentsRepository;

public class CompareFilesCommand extends Command {

    public CompareFilesCommand(String input,
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
        if (data.length != 3) {
            throw new InvalidInputException(this.getInput());
        }

        String firstPath = data[1];
        String secondPath = data[2];
        this.getTester().compareContent(firstPath, secondPath);
    }
}
