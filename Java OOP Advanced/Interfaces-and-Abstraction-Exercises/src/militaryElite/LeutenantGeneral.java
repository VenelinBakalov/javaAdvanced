package militaryElite;

import java.util.Collections;
import java.util.List;

/**
 * Created by Venelin on 15.3.2017 г..
 */
public class LeutenantGeneral extends Private implements ILeutenantGeneral {

    private List<ISoldier> privates;

    public LeutenantGeneral(String id, String firstName, String lastName, double salary, List<ISoldier> privates) {
        super(id, firstName, lastName, salary);
        this.privates = privates;
    }

    @Override
    public List<ISoldier> getPrivates() {
        return Collections.unmodifiableList(this.privates);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString() + System.lineSeparator());
        sb.append("Privates:");
        this.privates.forEach(p -> sb.append(System.lineSeparator()).append("  ").append(p.toString()));
        return sb.toString();
    }
}
