package familyTree;


import java.util.ArrayList;
import java.util.List;

public class Person {

    private String name;
    private String birthDate;
    private List<Person> parents;
    private List<Person> children;

    public Person(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public List<Person> getParents() {
        return parents;
    }

    public List<Person> getChildren() {
        return children;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name).append(" ").append(this.birthDate).append("\r\n");
        sb.append("Parents:").append("\r\n");

        if (!this.parents.isEmpty()) {
            this.parents.forEach(p -> sb.append(p.getName()).append(" ").append(p.getBirthDate()).append("\r\n"));
        }

        sb.append("Children:").append("\r\n");
        if (!this.children.isEmpty()) {
            this.children.forEach(c -> sb.append(c.getName()).append(" ").append(c.getBirthDate()).append("\r\n"));
        }

        return sb.toString();
    }
}
