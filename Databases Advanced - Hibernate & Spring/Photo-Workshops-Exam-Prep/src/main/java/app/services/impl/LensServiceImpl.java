package app.services.impl;

import app.entities.Lens;
import app.repositories.LensRepository;
import app.services.api.LensService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Venelin on 12.8.2017 г..
 */
@Service
@Transactional
public class LensServiceImpl implements LensService {

    @Autowired
    private LensRepository lensRepository;

    @Override
    public List<Lens> addAll(Iterable<Lens> lenses) {
        return this.lensRepository.save(lenses);
    }

    @Override
    public List<Lens> findByIdIn(Iterable<Long> ids) {
        return lensRepository.findByIdIn(ids);
    }
}
