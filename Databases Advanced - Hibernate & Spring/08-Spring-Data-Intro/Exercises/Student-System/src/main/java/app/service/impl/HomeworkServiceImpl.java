package app.service.impl;

import app.dao.api.HomeworkDao;
import app.model.Homework;
import app.service.api.HomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Venelin on 21.7.2017 г..
 */
@Service
@Transactional
public class HomeworkServiceImpl implements HomeworkService<Homework, Long> {

    @Autowired
    private HomeworkDao dao;

    @Override
    public Homework findById(Long id) {
        return dao.findOne(id);
    }

    @Override
    public void remove(Homework object) {
        dao.delete(object);
    }

    @Override
    public List<Homework> findAll() {
        return dao.findAll();
    }

    @Override
    public void save(Homework object) {
        dao.save(object);
    }
}
