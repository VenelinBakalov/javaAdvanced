package app.service.impl;

import app.dao.api.StudentDao;
import app.model.Student;
import app.service.api.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Venelin on 21.7.2017 г..
 */
@Service
@Transactional
public class StudentServiceImpl implements StudentService<Student, Long> {

    @Autowired
    private StudentDao dao;

    @Override
    public Student findById(Long id) {
        return dao.findOne(id);
    }

    @Override
    public void remove(Student object) {
        dao.delete(object);
    }

    @Override
    public List<Student> findAll() {
        return dao.findAll();
    }

    @Override
    public void save(Student object) {
        dao.save(object);
    }

    @Override
    public List<Object[]> findAllStudentsAndHomeworkSubmissions() {
        return dao.findAllStudentsAndHomeworkSubmissions();
    }

    @Override
    public List<Object[]> findStudentInformation() {
        return dao.findStudentInformation();
    }
}
