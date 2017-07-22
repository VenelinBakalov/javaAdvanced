package app.dao.api;

import app.model.Student;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Venelin on 21.7.2017 г..
 */
@Repository
public interface StudentDao extends JpaRepository<Student, Long> {

    @Query("select s.name, h.content, h.contentType from Student as s inner join s.homeworkSubmissions as h")
    List<Object[]> findAllStudentsAndHomeworkSubmissions();
}
