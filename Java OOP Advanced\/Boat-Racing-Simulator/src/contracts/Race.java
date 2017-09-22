package contracts;

import exeptions.DuplicateModelException;
import models.boats.Boat;

import java.util.List;

public interface Race
{
    int getDistance();

    boolean getAllowsMotorboats();

    int getOceanCurrentSpeed();

    int getWindSpeed();

    void addParticipant(Raceable boat) throws DuplicateModelException;

    List<Raceable> getParticipants();
}
