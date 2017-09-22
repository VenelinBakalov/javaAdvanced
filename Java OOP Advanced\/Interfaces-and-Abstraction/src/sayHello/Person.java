package sayHello;

/**
 * Created by Venelin on 14.3.2017 г..
 */
public interface Person {

    String getName();

    default String sayHello() {
        return "Hello";
    }
}
