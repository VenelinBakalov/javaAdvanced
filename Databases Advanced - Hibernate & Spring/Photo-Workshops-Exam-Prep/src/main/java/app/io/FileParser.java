package app.io;

import org.springframework.stereotype.Component;

import java.io.*;

/**
 * Created by Venelin on 6.8.2017 г..
 */
@Component
public class FileParser {

    public String read(String filePath) throws IOException {
        StringBuilder sb = new StringBuilder();
        InputStream is = this.getClass().getResourceAsStream(filePath);

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line = "";

            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                //log here
            }
        }


        return sb.toString();
    }

    public void write(String content, String filePath) throws IOException {
        OutputStream os = new FileOutputStream(filePath);

        try {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os));
            writer.write(content);
            writer.flush();
        } finally {
            try {
                os.close();
            } catch (IOException e) {
                //log here
            }
        }
    }
}
