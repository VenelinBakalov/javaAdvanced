package randomArrayList;

/**
 * Created by Venelin on 1.3.2017 г..
 */
public class Main {

    public static void main(String[] args) {
        RandomArrayList ral = new RandomArrayList();
        ral.add("Pesho");
        ral.add(1);
        ral.add("989808");
        ral.add("ggggg");
        ral.add(3);

        System.out.println(ral.getRandomElement());
        System.out.println(ral.getRandomElement());
        System.out.println(ral.getRandomElement());
        System.out.println(ral.getRandomElement());

    }
}
