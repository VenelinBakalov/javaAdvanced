package app.dao.api;

import app.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by Venelin on 21.7.2017 г..
 */
@Repository
public interface CourseDao extends JpaRepository<Course, Long> {

    @Query("SELECT c.name, c.description, r from Course as c inner join c.resources as r order by c.startDate asc, c.endDate desc ")
    List<Object[]> findAllCoursesAndResources();

    @Query("SELECT concat(c.name, ' ', count(r)) from Course as c inner join c.resources as r group by c.name " +
            "having count(r) > 1 order by count(r) desc, c.startDate desc")
    List<String> findAllCoursesWithMoreThan5Resources();

    @Query("select c.name, c.startDate, c.endDate, datediff(c.endDate, c.startDate), count(s) from Course as c inner join c.students as s " +
            "group by c.name, c.startDate, c.endDate " +
            "having c.startDate < :date and c.endDate > :date " +
            "order by count(s) desc, datediff(c.endDate, c.startDate) desc")
    List<Object[]> findAllCoursesActiveOnDate(@Param("date")Date date);
}
