import java.io.*;

public class CopyAPictureExercises {
    private static final String PATH = System.getProperty("user.dir");
    public static void main(String[] args) throws IOException {
        String originalPicture = "/src/resources/gameAfTrons.png";
        String copyPicture = "/src/resources/copy-picture.jpg";
        FileInputStream inputStream = new FileInputStream(PATH + originalPicture);
        OutputStream outputStream = new FileOutputStream(PATH + copyPicture);

        int readBytes;
        byte[] bytesArr = new byte[512];

        while ((readBytes = inputStream.read(bytesArr)) != -1) {
            outputStream.write(readBytes);
        }

        inputStream.close();
        outputStream.close();
    }
}
