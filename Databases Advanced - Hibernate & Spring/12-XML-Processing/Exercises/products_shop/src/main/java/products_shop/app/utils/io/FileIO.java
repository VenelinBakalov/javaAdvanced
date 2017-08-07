package products_shop.app.utils.io;

import org.springframework.stereotype.Component;

import java.io.*;


@Component
public class FileIO {
    public String readFile(String path) throws IOException {
        StringBuilder sb = new StringBuilder();

        try (InputStream inputStream = this.getClass().getResourceAsStream(path);
             BufferedReader bf = new BufferedReader(new InputStreamReader(inputStream))) {

            String line = bf.readLine();

            while (null != line) {
                sb.append(line);
                line = bf.readLine();
            }
        }

        return sb.toString();
    }

    public void writeFile(String path, String content) throws IOException {

        String fullPath=System.getProperty("user.dir")+path;

        File file=new File(fullPath);

        if (!file.exists()){
            file.getParentFile().mkdirs();
            file.createNewFile();
        }

        try (OutputStream outputStream = new FileOutputStream(fullPath);
             BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(outputStream))) {
            bf.write(content);
        }
    }

}
