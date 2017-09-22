package equalityLogic;

/**
 * Created by Venelin on 23.3.2017 г..
 */
public class Person implements Comparable<Person> {

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Person)) {
            return false;
        }
        Person person = (Person) obj;

        if (this.getAge() != person.getAge()) {
            return false;
        }
        return this.getName() != null ? this.getName().equals(person.getName()) : person.getName() == null;
    }

//   @Override
//   public int hashCode() {
//       int result = name != null ? name.hashCode() : 0;
//       result = 31 * result + age;
//       return result;
//   }

    @Override
    public int hashCode() {
        int result = 17;

        result = 31 * result + this.getAge();
        result = 31 * result + this.getName().hashCode();

        return result;
    }

    @Override
    public int compareTo(Person person) {
        if (this.getName().compareTo(person.getName()) == 0) {
            return this.getAge() - person.getAge();
        }
        return this.getName().compareTo(person.getName());
    }
}
