package google;


import java.util.LinkedHashSet;
import java.util.Set;

public class Person {

    private String name;
    private Company company;
    private Set<Pokemon> pokemons;
    private Set<Parent> parents;
    private Set<Child> children;
    private Car car;

    public Person(String name) {
        this.name = name;
        this.pokemons = new LinkedHashSet<>();
        this.parents = new LinkedHashSet<>();
        this.children = new LinkedHashSet<>();
    }



    public Set<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Set<Parent> getParents() {
        return parents;
    }

    public Set<Child> getChildren() {
        return children;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name).append("\r\n");
        sb.append("Company:").append("\r\n");

        if (this.company != null) {
            sb.append(this.company).append("\r\n");
        }

        sb.append("Car:").append("\r\n");
        if (this.car != null) {
            sb.append(this.car).append("\r\n");
        }

        sb.append("Pokemon:").append("\r\n");
        if (!this.pokemons.isEmpty()) {
            this.pokemons.forEach(p -> sb.append(p).append("\r\n"));
        }

        sb.append("Parents:").append("\r\n");
        if (!this.parents.isEmpty()) {
            this.parents.forEach(p -> sb.append(p).append("\r\n"));
        }

        sb.append("Children:").append("\r\n");
        if (!this.children.isEmpty()){
            this.children.forEach(c -> sb.append(c).append("\r\n"));
        }

        return sb.toString();
    }
}
