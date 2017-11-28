package interfaces;

import models.Blob;

public interface Attack {

    void execute(Blob attacker, Blob target);

}
