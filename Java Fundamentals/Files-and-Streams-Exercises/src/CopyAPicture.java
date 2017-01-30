import java.io.*;

public class CopyAPicture {
    private static final String PROJECT_PATH = System.getProperty("user.dir") + "/src/resources/";
    private static final String IMAGE_PATH = PROJECT_PATH + "gameAfTrons.png";
    private static final String COPIED_IMAGE_PATH = PROJECT_PATH + "picture-copy.jpg";

    public static void main(String[] args) {

        File image = new File(IMAGE_PATH);
        File copy = new File(COPIED_IMAGE_PATH);

        try (FileInputStream fis = new FileInputStream(image);
             FileOutputStream fos = new FileOutputStream(copy)) {

            byte[] buffer = new byte[1024];
            int bytesRead = 0;
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
