package bg.softuni.io;

import bg.softuni.exceptions.InvalidInputException;
import bg.softuni.io.commands.*;
import bg.softuni.judge.Tester;
import bg.softuni.network.DownloadManager;
import bg.softuni.repository.StudentsRepository;

import java.io.IOException;

public class CommandInterpreter {

    private Tester tester;
    private StudentsRepository repository;
    private DownloadManager downloadManager;
    private IOManager ioManager;

    public CommandInterpreter(Tester tester,
                              StudentsRepository repository,
                              DownloadManager downloadManager,
                              IOManager ioManager) {
        this.tester = tester;
        this.repository = repository;
        this.downloadManager = downloadManager;
        this.ioManager = ioManager;
    }

    public void interpretCommand(String input) throws IOException {
        String[] data = input.split("\\s+");
        String commandName = data[0].toLowerCase();
        try {
            Command command = parseCommand(input, data, commandName);
            command.execute();
        } catch (Exception ex) {
            OutputWriter.displayException(ex.getMessage());
        }
    }

    private Command parseCommand(String input, String[] data, String command) {
        switch (command) {
            case "open":
                return new OpenFileCommand(input, data, this.tester,
                        this.repository, this.downloadManager, this.ioManager);
            case "mkdir":
                return new MakeDirectoryCommand(input, data, this.tester,
                        this.repository, this.downloadManager, this.ioManager);
            case "ls":
                return new TraverseFoldersCommand(input, data, this.tester,
                        this.repository, this.downloadManager, this.ioManager);
            case "cmp":
                return new CompareFilesCommand(input, data, this.tester,
                        this.repository, this.downloadManager, this.ioManager);
            case "cdrel":
                return new ChangeRelativePathCommand(input, data, this.tester,
                        this.repository, this.downloadManager, this.ioManager);
            case "cdabs":
                return new ChangeAbsolutePathCommand(input, data, this.tester,
                        this.repository, this.downloadManager, this.ioManager);
            case "readdb":
                return new ReadDatabaseCommand(input, data, this.tester,
                        this.repository, this.downloadManager, this.ioManager);
            case "help":
                return new GetHelpCommand(input, data, this.tester,
                        this.repository, this.downloadManager, this.ioManager);
            case "show":
                return new ShowCourseCommand(input, data, this.tester,
                        this.repository, this.downloadManager, this.ioManager);
            case "filter":
                return new PrintFilteredStudentsCommand(input, data, this.tester,
                        this.repository, this.downloadManager, this.ioManager);
            case "order":
                return new PrintOrderedStudentsCommand(input, data, this.tester,
                        this.repository, this.downloadManager, this.ioManager);
            case "download":
                return new DownloadFileCommand(input, data, this.tester,
                        this.repository, this.downloadManager, this.ioManager);
            case "downloadasynch":
                return new DownloadAsynchCommand(input, data, this.tester,
                        this.repository, this.downloadManager, this.ioManager);
            case "dropdb":
                return new DropDatabaseCommand(input, data, this.tester,
                        this.repository, this.downloadManager, this.ioManager);
            case "display":
                return new DisplayCommand(input, data, this.tester,
                        this.repository, this.downloadManager, this.ioManager);
            default:
                throw new InvalidInputException(input);
        }
    }
}
