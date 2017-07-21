package app.service.impl;

import app.dao.api.CategoryDao;
import app.model.Category;
import app.service.api.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Venelin on 20.7.2017 г..
 */
@Service
@Transactional
public class CategoryServiceImpl implements CategoryService<Category, Long> {

    @Autowired
    private CategoryDao dao;

    @Override
    public Category findById(Long id) {
        return dao.findOne(id);
    }

    @Override
    public void remove(Category object) {
        dao.delete(object);
    }

    @Override
    public List<Category> findAll() {
        return dao.findAll();
    }

    @Override
    public void save(Category object) {
        dao.save(object);
    }
}
