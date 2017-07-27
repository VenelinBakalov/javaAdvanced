package app.serrvice.impl;

import app.dao.api.IngredientsDao;
import app.model.BasicShampoos;
import app.service.api.IngredientService;
import app.model.BasicIngredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by User on 18.7.2017 г..
 */
@Service
@Transactional
public class IngredientsServiceImpl implements IngredientService<BasicIngredient, Long> {

    @Autowired
    private IngredientsDao dao;

    @Override
    public BasicIngredient findById(Long id) {
        return dao.findOne(id);
    }

    @Override
    public void remove(BasicIngredient object) {
        dao.delete(object);
    }

    @Override
    public List<BasicIngredient> findAll(Class<BasicIngredient> serviceClass) {
        return dao.findAll();
    }

    @Override
    public void save(BasicIngredient object) {
        dao.save(object);
    }

    @Override
    public List<BasicIngredient> findByNameEndsWith(String suffix) {
        return dao.findByNameEndingWith(suffix);
    }

    @Override
    public List<BasicShampoos> shampoosWithIngredient(BasicIngredient ingredient) {
        return dao.shampoosWithIngredient(ingredient);
    }
}
