
public class Person {

    private String name;
    private int age;


    public Person() {
        this(1);
    }

    public Person(int age) {
        this("No name", age);
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
