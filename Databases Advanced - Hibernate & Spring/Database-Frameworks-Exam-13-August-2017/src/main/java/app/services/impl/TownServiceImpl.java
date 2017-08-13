package app.services.impl;

import app.constants.ResultMessages;
import app.entities.Town;
import app.repositories.TownRepository;
import app.services.api.TownService;
import app.utils.DataValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TownServiceImpl implements TownService {

    @Autowired
    private TownRepository townRepository;

    @Override
    public String add(Town town) {
        String result;

        if (DataValidator.isValid(town)) {
            this.townRepository.save(town);
            result = String.format(ResultMessages.SUCCESSFUL,
                    town.getClass().getSimpleName(),
                    town);
        } else {
            result = ResultMessages.ERROR;
        }

        return result;
    }

    @Override
    public Town findByName(String name) {
        return this.townRepository.findByName(name);
    }

    @Override
    public List<Town> findAll() {
        return this.townRepository.findAll();
    }
}
