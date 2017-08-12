package app.serialize.impl;

import app.exceptions.SerializeException;
import app.io.FileParser;
import app.serialize.api.Serializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

/**
 * Created by Venelin on 6.8.2017 г..
 */
@Component("JsonSerializer")
public class JsonSerializer implements Serializer {

    private static final String PROJECT_DIRECTORY = System.getProperty("user.dir");
    private Gson gson;

    @Autowired
    private FileParser fileParser;

    public JsonSerializer() {
        this.gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
                .serializeNulls()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                .create();
    }

    @Override
    public <T> void serialize(T serializable, String filePath) {
        String qualifiedPath = PROJECT_DIRECTORY + File.separator + filePath;

        String json = gson.toJson(serializable);

        try {
            File file = new File(qualifiedPath);

            if (! file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }

            fileParser.write(json, filePath);
        } catch (IOException e) {
            //log here
            throw new SerializeException(json + " was not serialized to " + qualifiedPath, e);
        }
    }

    @Override
    public <T> T deserialize(Class<T> classType, String filePath) {
        try {
            String jsonInput = this.fileParser.read(filePath);
            return gson.fromJson(jsonInput, classType);
        } catch (IOException e) {
            //log here
            throw new SerializeException(filePath + " was not deserialized" + filePath, e);
        }
    }
}
