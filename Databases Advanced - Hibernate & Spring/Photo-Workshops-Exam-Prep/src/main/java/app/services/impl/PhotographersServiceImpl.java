package app.services.impl;

import app.dto.photographers.PhotographerImportJsonDto;
import app.entities.BasicCamera;
import app.entities.DSLRCamera;
import app.entities.Lens;
import app.entities.Photographer;
import app.repositories.CamerasRepository;
import app.repositories.LensRepository;
import app.repositories.PhotographersRepository;
import app.services.api.PhotographersService;
import app.utils.DTOConverter;
import app.utils.DataValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Venelin on 12.8.2017 г..
 */
@Service
@Transactional
public class PhotographersServiceImpl implements PhotographersService {
    
    @Autowired
    private PhotographersRepository photographersRepository;

    @Autowired
    private LensRepository lensRepository;

    @Autowired
    private CamerasRepository camerasRepository;

    @Override
    public Photographer add(PhotographerImportJsonDto photographerImport) {
        Photographer photographer = DTOConverter.convert(photographerImport, Photographer.class);
        addCameras(photographer);

        Photographer persisted = null;

        if (DataValidator.isValid(photographer)) {
            List<Lens> lenses = this.lensRepository.findByIdIn(photographerImport.getLenses());
            List<Lens> resultList = new ArrayList<>();
            for (Lens lens : lenses) {
                if (isCompatible(lens, photographer.getPrimaryCamera()) &&
                        isCompatible(lens, photographer.getSecondaryCamera())) {
                    lens.setOwner(photographer);
                    resultList.add(lens);
                } else {
                    System.out.println("Lens if not compatible");
                }
            }

            photographer.setLenses(resultList);
            persisted = this.photographersRepository.save(photographer);
            System.out.println("Successfully imported " + photographer);
        } else {
            System.out.println("Error. Invalid data provided");
        }


        return persisted;
    }

    @Override
    public List<Photographer> findLandscapePhotographers() {
        List<Photographer> photographersWithSmallLens = this.photographersRepository.findPhotographersWithSmallLens();
        List<Photographer> landscapePhotographers = new ArrayList<>();
        for (Photographer photographer : photographersWithSmallLens) {
            if (photographer.getPrimaryCamera() instanceof DSLRCamera) {
                landscapePhotographers.add(photographer);
            }
        }

        return landscapePhotographers;
    }

    private void addCameras(Photographer photographer) {
        Long count = camerasRepository.count();

        if (photographer.getPrimaryCamera() == null) {
            long id = ThreadLocalRandom.current().nextLong(1, count);
            photographer.setPrimaryCamera(camerasRepository.findOne(id));
        }

        if (photographer.getSecondaryCamera() == null) {
            long id = ThreadLocalRandom.current().nextLong(1, count);
            photographer.setSecondaryCamera(camerasRepository.findOne(id));
        }
    }

    private boolean isCompatible(Lens lens, BasicCamera camera) {
        return lens.getCompatibleWith() != null &&
                lens.getCompatibleWith().equals(camera.getMake());
    }
}
