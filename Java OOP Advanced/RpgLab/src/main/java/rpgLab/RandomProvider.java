package rpgLab;

import java.util.Random;

/**
 * Created by Venelin on 30.3.2017 г..
 */
public interface RandomProvider {

    int nextInt(int max);

    class Implementation implements RandomProvider {

        private Random random;

        public Implementation() {
            this.random = new Random();
        }

        public int nextInt(int max) {
            return this.random.nextInt(max);
        }
    }
}
