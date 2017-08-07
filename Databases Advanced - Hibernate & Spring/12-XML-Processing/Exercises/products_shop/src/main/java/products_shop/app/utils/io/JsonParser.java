package products_shop.app.utils.io;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class JsonParser {
    private Gson gson;
    private final FileIO fileIO;

    @Autowired
    public JsonParser(FileIO fileIO) {
        this.fileIO = fileIO;
        this.gson=new GsonBuilder().excludeFieldsWithoutExposeAnnotation().
                setPrettyPrinting().create();
    }

    public <T> T getObject(Class<T> clazz,String path) throws IOException {
        T object=null;

        String json=this.fileIO.readFile(path);
        object=this.gson.fromJson(json,clazz);
        return object;
    }

    public <T> void writeObject(T clazz,String path) throws IOException {
        String json=this.gson.toJson(clazz);
        this.fileIO.writeFile(path,json);
    }

}
