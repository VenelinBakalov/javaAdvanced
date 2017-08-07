package products_shop.app.utils.io;

import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

/**
 * Created by Venelin on 7.8.2017 г..
 */
@Component
public class XMLParser {

    private JAXBContext jaxbContext;

    public XMLParser() throws JAXBException {
    }

    @SuppressWarnings("unchecked")
    public <T> T getObject(Class<T> clazz, String path) throws JAXBException, IOException {
        this.jaxbContext = JAXBContext.newInstance(clazz);
        Unmarshaller unmarshaller = this.jaxbContext.createUnmarshaller();
        T object = null;
        try (
                InputStream is = this.getClass().getResourceAsStream(path);
                ) {
            object = (T) unmarshaller.unmarshal(is);
        }

        return object;
    }

    public <T> void writeObject(T object, String path) throws JAXBException, IOException {
        this.jaxbContext = JAXBContext.newInstance(object.getClass());
        Marshaller marshaller = this.jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        try (
                OutputStream os = new FileOutputStream(path);
                ){
            marshaller.marshal(object, os);
        }
    }
}
