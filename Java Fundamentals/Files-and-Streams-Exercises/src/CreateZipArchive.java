import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CreateZipArchive {
    private static final String PROJECT_PATH = System.getProperty("user.dir") + "/src/resources/";
    private static final String FIRST_FILE = PROJECT_PATH + "text.txt";
    private static final String SECOND_FILE = PROJECT_PATH + "words.txt";
    private static final String THIRD_FILE = PROJECT_PATH + "results.txt";
    private static final String ZIP_PATH = PROJECT_PATH + "files.zip";

    public static void main(String[] args) throws IOException {

        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(ZIP_PATH));


        try (FileInputStream fisFirst = new FileInputStream(new File(FIRST_FILE));
             FileInputStream fisSecond = new FileInputStream(new File(SECOND_FILE));
             FileInputStream fisThird = new FileInputStream(new File(THIRD_FILE))) {
            int byteContainer;
            zos.putNextEntry(new ZipEntry("text.txt"));

            while ((byteContainer = fisFirst.read()) != -1) {
                zos.write(byteContainer);
            }
            zos.closeEntry();

            zos.putNextEntry(new ZipEntry("words.txt"));

            while ((byteContainer = fisSecond.read()) != -1){
                zos.write(byteContainer);
            }
            zos.closeEntry();

            zos.putNextEntry(new ZipEntry("results.txt"));

            while ((byteContainer = fisThird.read()) != -1) {
                zos.write(byteContainer);
            }
            zos.closeEntry();

        } catch (IOException e1) {
            e1.printStackTrace();
        }

        zos.finish();
        zos.close();
    }
}


