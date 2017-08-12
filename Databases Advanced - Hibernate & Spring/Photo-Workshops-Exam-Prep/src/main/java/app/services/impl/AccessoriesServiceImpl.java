package app.services.impl;

import app.entities.Accessory;
import app.repositories.AccessoriesRepository;
import app.services.api.AccessoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Venelin on 13.8.2017 г..
 */
@Service
@Transactional
public class AccessoriesServiceImpl implements AccessoriesService {

    @Autowired
    private AccessoriesRepository accessoriesRepository;

    @Override
    public List<Accessory> addAll(Iterable<Accessory> accessories) {
        return this.accessoriesRepository.save(accessories);
    }
}
