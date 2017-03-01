package randomArrayList;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Venelin on 1.3.2017 г..
 */
public class RandomArrayList extends ArrayList{

    private Random random;

    public RandomArrayList() {
        this.random = new Random();
    }

    public Object getRandomElement() {
        int index = random.nextInt(super.size());
        Object element = super.get(index);
        super.set(index, super.get(super.size() - 1));
        this.remove(super.size() - 1);

        return element;
    }
}
