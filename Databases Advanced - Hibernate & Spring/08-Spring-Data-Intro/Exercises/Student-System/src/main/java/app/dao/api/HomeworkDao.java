package app.dao.api;

import app.model.Homework;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Venelin on 21.7.2017 г..
 */
@Repository
public interface HomeworkDao extends JpaRepository<Homework, Long> {
}
