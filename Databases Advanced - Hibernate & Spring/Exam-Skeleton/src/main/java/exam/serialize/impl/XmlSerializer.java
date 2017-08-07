package exam.serialize.impl;

import exam.exceptions.SerializeException;
import exam.serialize.api.Serializer;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

/**
 * Created by Venelin on 6.8.2017 г..
 */
@Component("XmlSerializer")
public class XmlSerializer implements Serializer {

    private static final String PROJECT_DIRECTORY = System.getProperty("user.dir");

    @Override
    public <T> void serialize(T serializable, String filePath) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(serializable.getClass());
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            String qualifiedPath = PROJECT_DIRECTORY + File.separator + filePath;
            File file = new File(qualifiedPath);

            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }

            try (OutputStream os = new FileOutputStream(filePath);
                 BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os))) {
                marshaller.marshal(serializable, writer);
            }

        } catch (JAXBException e) {
            //log here
            throw new SerializeException("Could not serialize " + serializable.getClass().getSimpleName(), e);
        } catch (IOException ioe) {
            // log here
            throw new SerializeException("Could not serialize " + serializable.getClass().getSimpleName() +
                    ". Unable to write to file " + filePath, ioe);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T deserialize(Class<T> classType, String filePath) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(classType);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            try (InputStream is = classType.getResourceAsStream(filePath);
                 BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
                T t = (T) unmarshaller.unmarshal(reader);

                return t;
            }
        } catch (JAXBException e) {
            // log here
            throw new SerializeException("Could not deserialize " + filePath + " to class " + classType, e);
        } catch (IOException e) {
            // log here
            throw new SerializeException("Could not deserialize " + filePath + " to class " + classType +
                    ". Unable to read from file " + filePath, e);
        }
    }
}
