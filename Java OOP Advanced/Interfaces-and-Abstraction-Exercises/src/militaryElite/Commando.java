package militaryElite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Venelin on 15.3.2017 г..
 */
public class Commando extends SpecialisedSoldier implements ICommando {

    private List<Mission> missions;

    public Commando(String id, String firstName, String lastName, double salary, String corps, List<Mission> missions) {
        super(id, firstName, lastName, salary, corps);
        this.missions = missions;
    }


    @Override
    public List<Mission> getMissions() {
        return Collections.unmodifiableList(this.missions);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString() + System.lineSeparator());
        sb.append("Missions:");
        this.missions.forEach(m -> sb.append(System.lineSeparator()).append("  ").append(m.toString()));
        return sb.toString();
    }
}
