package contracts;

import exeptions.DuplicateModelException;
import models.boats.Boat;

import java.util.List;

public interface Race
{
    int getDistance();

    boolean getAllowsMotorboats();

    void addParticipant(Raceable boat) throws DuplicateModelException;

    Iterable<Raceable> getParticipants();
}
