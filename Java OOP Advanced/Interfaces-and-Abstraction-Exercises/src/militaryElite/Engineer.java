package militaryElite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Venelin on 15.3.2017 г..
 */
public class Engineer extends SpecialisedSoldier implements IEngineer {

    private List<Repair> repairs;

    public Engineer(String id, String firstName, String lastName, double salary, String corps, List<Repair> repairs) {
        super(id, firstName, lastName, salary, corps);
        this.repairs = repairs;
    }

    @Override
    public List<Repair> getRepairs() {
        return Collections.unmodifiableList(this.repairs);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString() + System.lineSeparator());
        sb.append("Repairs:");
        this.repairs.forEach(r -> sb.append(System.lineSeparator()).append("  ").append(r.toString()));

        return sb.toString();
    }
}
