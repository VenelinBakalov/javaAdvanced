package app.dao.impl;

import app.dao.api.IngedientsDaoCustom;
import app.model.BasicIngredient;
import app.model.BasicShampoos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by User on 19.7.2017 г..
 */
@Repository
public class IngredientsDaoImpl implements IngedientsDaoCustom {

    @Autowired
    private EntityManager em;


    @Override
    public List<BasicShampoos> shampoosWithIngredient(BasicIngredient ingredient) {
        List<BasicShampoos> allShampoos = em.createQuery("From BasicShampoos").getResultList();
        List<BasicShampoos> result =  allShampoos
                .stream()
                .filter(s -> s.getIngredients().contains(ingredient))
                .collect(Collectors.toList());
        return result;
    }
}
