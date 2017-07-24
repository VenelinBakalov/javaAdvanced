package app.service.api;

import java.util.List;

/**
 * Created by Venelin on 21.7.2017 г..
 */
public interface StudentService<Student, Long> extends ServiceInterface<Student, Long> {

    List<Object[]> findAllStudentsAndHomeworkSubmissions();
    List<Object[]> findStudentInformation();
}
