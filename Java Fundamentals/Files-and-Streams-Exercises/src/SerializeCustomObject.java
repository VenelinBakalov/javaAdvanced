import java.io.*;

public class SerializeCustomObject {
    private static final String PROJECT_PATH = System.getProperty("user.dir") + "/src/resources/";
    private static final String SERIALIZED_CLASS = PROJECT_PATH + "course.ser";

    public static void main(String[] args) {

        Course javaAdvanced = new Course("Java Advanced", 150);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SERIALIZED_CLASS));
             ObjectInputStream ois = new ObjectInputStream(new FileInputStream(SERIALIZED_CLASS))) {

            oos.writeObject(javaAdvanced);

            Course loadedCourse = (Course) ois.readObject();

            System.out.println(loadedCourse.getName() + " course has " + loadedCourse.getStudentsCount() + " students.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
