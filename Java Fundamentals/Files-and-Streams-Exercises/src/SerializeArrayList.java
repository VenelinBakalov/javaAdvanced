import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SerializeArrayList {
    private static final String PROJECT_PATH = System.getProperty("user.dir") + "/src/resources/";
    private static final String SERIALIZED_FILE = PROJECT_PATH + "list.ser";
    public static void main(String[] args) {
        List<Double> doubles = new ArrayList<>();
        Collections.addAll(doubles, 22.5, 13.75, 55.00, 42.5);

        try (FileOutputStream fos = new FileOutputStream(SERIALIZED_FILE)) {
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(doubles);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileInputStream fis = new FileInputStream(SERIALIZED_FILE);
        ObjectInputStream ois = new ObjectInputStream(fis)) {
            List<Double> loadedDoubles = (List<Double>) ois.readObject();
            System.out.println(loadedDoubles.toString());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
