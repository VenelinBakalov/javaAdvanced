package companyHierarchy;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Venelin on 4.3.2017 г..
 */
public class Developer extends RegularEmployee {

    private Set<Project> projects;

    public Developer(Integer id, String firstName, String lastName, Double salary, Department department) {
        super(id, firstName, lastName, salary, department);
        this.projects = new HashSet<>();
    }

    @Override
    public String toString() {
        return "Developer{" +
                "projects=" + projects +
                '}';
    }
}
