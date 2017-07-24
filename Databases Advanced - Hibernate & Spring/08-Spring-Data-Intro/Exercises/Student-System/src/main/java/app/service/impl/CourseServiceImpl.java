package app.service.impl;

import app.dao.api.CourseDao;
import app.model.Course;
import app.service.api.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by Venelin on 21.7.2017 г..
 */
@Service
@Transactional
public class CourseServiceImpl implements CourseService<Course, Long> {

    @Autowired
    private CourseDao dao;

    @Override
    public Course findById(Long id) {
        return dao.findOne(id);
    }

    @Override
    public void remove(Course object) {
        dao.delete(object);
    }

    @Override
    public List<Course> findAll() {
        return dao.findAll();
    }

    @Override
    public void save(Course object) {
        dao.save(object);
    }

    @Override
    public List<Object[]> findAllCoursesAndResources() {
        return dao.findAllCoursesAndResources();
    }

    @Override
    public List<String> findAllCoursesWithMoreThan5Resources() {
        return dao.findAllCoursesWithMoreThan5Resources();
    }

    @Override
    public List<Object[]> findAllCoursesActiveOnDate(Date date) {
        return dao.findAllCoursesActiveOnDate(date);
    }
}
