package app.service.api;

import java.util.Date;
import java.util.List;

/**
 * Created by Venelin on 21.7.2017 г..
 */
public interface CourseService<Course, Long> extends ServiceInterface<Course, Long> {

    List<Object[]> findAllCoursesAndResources();

    List<String> findAllCoursesWithMoreThan5Resources();

    List<Object[]> findAllCoursesActiveOnDate(Date date);

}
