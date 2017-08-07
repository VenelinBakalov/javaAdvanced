package exam.serialize.api;

/**
 * Created by Venelin on 6.8.2017 г..
 */
public interface Serializer {

    <T> void serialize(T serializable, String filePath);

    <T> T deserialize(Class<T> classType, String filePath);
}
