package bg.softuni.io.commands;

import bg.softuni.contracts.Course;
import bg.softuni.contracts.Student;
import bg.softuni.dataStructures.SimpleSortedList;
import bg.softuni.exceptions.InvalidInputException;
import bg.softuni.io.IOManager;
import bg.softuni.io.OutputWriter;
import bg.softuni.judge.Tester;
import bg.softuni.network.DownloadManager;
import bg.softuni.repository.StudentsRepository;

import java.util.Comparator;

/**
 * Created by Venelin on 29.3.2017 г..
 */
public class DisplayCommand extends Command {

    public DisplayCommand(String input,
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

        String entityToDisplay = data[1];
        String sortType = data[2];
        if (entityToDisplay.equalsIgnoreCase("students")) {
            Comparator<Student> studentComparator =
                    this.createStudentComparator(sortType);
            SimpleSortedList<Student> list =
                    this.getRepository().getAllStudentsSorted(studentComparator);
            OutputWriter.writeMessageOnNewLine(
                    list.joinWith(System.lineSeparator()));
        } else if (entityToDisplay.equalsIgnoreCase("courses")) {
            Comparator<Course> courseComparator =
                    this.createCourseComparator(sortType);
            SimpleSortedList<Course> list =
                    this.getRepository().getAllCoursesSorted(courseComparator);
            OutputWriter.writeMessageOnNewLine(
                    list.joinWith(System.lineSeparator()));
        } else {
            throw new InvalidInputException(this.getInput());
        }

    }

    private Comparator<Student> createStudentComparator(String sortType) {
        if (sortType.equalsIgnoreCase("ascending")) {
            return Comparable::compareTo;
            //  return (o1, o2) -> o1.compareTo(o2);
        } else if (sortType.equalsIgnoreCase("descending")) {
            return (o1, o2) -> o2.compareTo(o1);
        } else {
            throw new InvalidInputException(this.getInput());
        }
    }
}
