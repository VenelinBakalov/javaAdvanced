package bg.softuni.io.commands;

import bg.softuni.exceptions.InvalidInputException;
import bg.softuni.io.IOManager;
import bg.softuni.judge.Tester;
import bg.softuni.network.DownloadManager;
import bg.softuni.repository.StudentsRepository;

public class ShowCourseCommand extends Command {

    public ShowCourseCommand(String input,
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
        if (data.length != 2 && data.length != 3) {
            throw new InvalidInputException(this.getInput());
        }

        if (data.length == 2) {
            String courseName = data[1];
            this.getRepository().getStudentsByCourse(courseName);
            return;
        }

        String courseName = data[1];
        String userName = data[2];
        this.getRepository().getStudentMarkInCourse(courseName, userName);

    }
}
