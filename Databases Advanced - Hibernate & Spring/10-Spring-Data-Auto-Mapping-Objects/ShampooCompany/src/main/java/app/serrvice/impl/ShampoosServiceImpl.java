package app.serrvice.impl;

import app.dao.api.ProductionBatchDao;
import app.dao.api.ShampoosDao;
import app.model.BasicIngredient;
import app.model.ProductionBatch;
import app.service.api.ShampoosService;
import app.model.BasicShampoos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by User on 18.7.2017 г..
 */
@Service
@Transactional
public class ShampoosServiceImpl implements ShampoosService<BasicShampoos, Long> {

    private final ShampoosDao dao;

    private final ProductionBatchDao productionBatchDao;

    @Autowired
    public ShampoosServiceImpl(ShampoosDao dao, ProductionBatchDao productionBatchDao) {
        this.dao = dao;
        this.productionBatchDao = productionBatchDao;
    }

    @Override
    public BasicShampoos findById(Long id) {
        return dao.findOne(id);
    }

    @Override
    public void remove(BasicShampoos object) {
        dao.delete(object);
    }

    @Override
    public List<BasicShampoos> findAll(Class<BasicShampoos> serviceClass) {
        return dao.findAll();
    }

    @Override
    public void save(BasicShampoos shampoo) {
        if(shampoo.getBatch() == null) {
            ProductionBatch batch = productionBatchDao.findOne(1L);
            shampoo.setBatch(batch);
        }
        dao.saveAndFlush(shampoo);
    }

    @Override
    public List<BasicShampoos> shampoosWithIngredient(String ingredient) {
        return dao.shampoosWithIngredient(ingredient);
    }
}
