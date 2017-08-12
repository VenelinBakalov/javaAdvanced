package app.services.impl;

import app.entities.Photographer;
import app.entities.Workshop;
import app.repositories.PhotographersRepository;
import app.repositories.WorkshopsRepository;
import app.services.api.WorkshopsService;
import app.utils.DataValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Created by Venelin on 12.8.2017 г..
 */
@Service
@Transactional
public class WorkshopsServiceImpl implements WorkshopsService {

    @Autowired
    private WorkshopsRepository workshopsRepository;

    @Autowired
    private PhotographersRepository photographersRepository;

    @Override
    public Workshop add(Workshop workshop) {
        Workshop persisted = null;

        if (DataValidator.isValid(workshop)) {
            Photographer trainer = photographersRepository.findByFirstNameAndLastName(workshop.getTrainer().getFirstName(), workshop.getTrainer().getLastName());
            workshop.setTrainer(trainer);

            Set<Photographer> participants = new HashSet<>();

            if (workshop.getParticipants() != null) {
                for (Photographer participant : workshop.getParticipants()) {
                    Photographer updatedParticipant = photographersRepository.findByFirstNameAndLastName(participant.getFirstName(), participant.getLastName());
                    participants.add(updatedParticipant);
                }
                workshop.setParticipants(participants);
            }

            if (DataValidator.isValid(workshop)) {
                persisted = this.workshopsRepository.save(workshop);
                System.out.println("Successfully imported " + workshop.getName());
            } else {
                System.out.println("Ni staa, preeba neshtata");
            }
        } else {
            System.out.println("Ni staa, preeba neshtata");
        }

        return persisted;
    }

    @Override
    public Map<String, List<Workshop>> findWorkshopsByLocation() {
        Map<String, List<Workshop>> resultMap = new HashMap<>();
        List<String> allLocations = workshopsRepository.findAllLocations();

        for (String location : allLocations) {
            List<Workshop> workshopsByLocation = this.workshopsRepository.findWorkshopsByLocation(location);
            if (workshopsByLocation.size() > 0) {
                resultMap.put(location, workshopsByLocation);
            }
        }

        return resultMap;
    }
}
