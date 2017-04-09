package contracts;

import exeptions.DuplicateModelException;
import models.MotorBoat;

import java.util.List;

public interface IRace
{
    int getDistance();

    int getWindSpeed();

    int getOceanCurrentSpeed();

    Boolean getAllowsMotorboats();

    void AddParticipant(MotorBoat boat) throws DuplicateModelException;

    List<MotorBoat> GetParticipants();
}
