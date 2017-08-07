package exam.terminal;

import exam.dto.PersonDto;
import exam.serialize.api.Serializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by Venelin on 6.8.2017 г..
 */
@Component
public class Terminal implements CommandLineRunner {

    private static final String OBJECT_INPUT_JSON = "/files/input/json/***.json";
    private static final String OBJECT_OUTPUT_JSON = "src/main/resources/files/input/json/***.json";

    // @SerializedName - when Json name != field name
    // ObjectDto[].class when you have collection in  .json
    // Qualifier - when you have many implementations for autowire
    // @Valid - validate a field inside the object

    // @EntityListeners(PersonListener.class) -> @PrePersist

    /*
     if (! DataValidator.checkIsValid(addGame)) {
            return DataValidator.getInvalidParameterMessage(addGame);
        }

     */

    @Autowired
    @Qualifier("JsonSerializer")
    private Serializer jsonSerializer;

    @Autowired
    @Qualifier("XmlSerializer")
    private Serializer xmlSerializer;

    @Override
    public void run(String... strings) throws Exception {

    }

//    private void importObject() {
//        jsonSerializer.deserialize(ObjectDTO.class ,OBJECT_INPUT_JSON);
//    }

    private void importPersonXml() {
        PersonDto personDto = xmlSerializer.deserialize(PersonDto.class, OBJECT_INPUT_JSON);
//        DTOConverter.convert(personDto, Person.class);
//        personService.persist(person);
    }
}
