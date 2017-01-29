import java.io.*;

public class SerializaCustomObject {
    public static void main(String[] args) {
        final String objectPath = "D:\\Demon Hunter New\\Soft Uni\\javaAdvanced\\Java Fundamentals\\Files-and-Streams-Lab\\05. Java-Advanced-Files-and-Directories-Lab-Resources\\object.ser";

        Cube cube = new Cube();
        cube.color = "green";
        cube.depth = 13;
        cube.width = 14;
        cube.height = 5;

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(objectPath))) {
            oos.writeObject(cube);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(objectPath))){
            Cube loadedCube = (Cube) ois.readObject();
            System.out.println(loadedCube.color);
            System.out.println(loadedCube.depth);
            System.out.println(loadedCube.width);
            System.out.println(loadedCube.height);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
