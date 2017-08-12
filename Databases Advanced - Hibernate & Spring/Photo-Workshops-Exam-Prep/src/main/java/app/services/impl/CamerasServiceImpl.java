package app.services.impl;

import app.entities.BasicCamera;
import app.repositories.CamerasRepository;
import app.services.api.CamerasService;
import app.utils.DataValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Venelin on 12.8.2017 г..
 */
@Service
@Transactional
public class CamerasServiceImpl implements CamerasService {

    @Autowired
    private CamerasRepository camerasRepository;

    @Override
    public BasicCamera add(BasicCamera camera) {
        BasicCamera persistedCamera = null;

        if (DataValidator.isValid(camera)) {
            persistedCamera = this.camerasRepository.save(camera);
            System.out.println("Camera bla bla saved");
        } else {
            System.out.println("hoi, ne stana brat!");
        }

        return persistedCamera;
    }
}
