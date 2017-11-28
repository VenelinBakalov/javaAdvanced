package jarofT;

/**
 * Created by Venelin on 16.3.2017 г..
 */
public class Main {

    public static void main(String[] args) {
        Jar<Integer> intJar = new Jar<>();
        intJar.add(1);
        intJar.add(2);
        System.out.println(intJar.remove());
        System.out.println(intJar.remove());
    }
}
