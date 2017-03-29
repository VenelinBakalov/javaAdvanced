package bg.softuni.io.commands;

import bg.softuni.exceptions.InvalidInputException;
import bg.softuni.io.IOManager;
import bg.softuni.judge.Tester;
import bg.softuni.network.DownloadManager;
import bg.softuni.repository.StudentsRepository;

public class DownloadAsynchCommand extends Command {

    public DownloadAsynchCommand(String input,
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
        if (data.length != 2) {
            throw new InvalidInputException(this.getInput());
        }

        String fileUrl = data[1];
        this.getDownloadManager().downloadOnNewThread(fileUrl);
    }
}
