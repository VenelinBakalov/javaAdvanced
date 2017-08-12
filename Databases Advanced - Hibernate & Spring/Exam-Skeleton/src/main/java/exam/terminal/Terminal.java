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

    // deserialize(LensImportJsonDto[].class,...)
    // MappingUtil.conver(Arrays.asList(dtos), ...)
    // @SerializedName - when Json name != field name
    // ObjectDto[].class when you have collection in  .json
    // Qualifier - when you have many implementations for autowire
    // @Valid - validate a field inside the object

    // @EntityListeners(PersonListener.class) -> @PrePersist

    // repository.count();
    // ThreadLocalRandom.current().nextLong(1, count);

    // disable html escape??
    // .serializeNulls() in gsonBuilder prints nulls and doesn't escape them

    // @XmlValue - when you have the element tag in the wrapper and don't need another tag, just the value
    // you have values and need to export the concat of those  -> @XmlTransient on the fields and just @Expose on a
    // getter (getLensInfo) containing the concatenation logic

    // Don't need @XmlRootElement on a wrapped object or lower than first level object

    // @XmlTransient primaryCameraModel;

    // Export xml List<t> -> XmlElementWrapper

    // where p.lens NOT NULL OR!!! INNER JOIN and the null values are out

    // if collection.size() == 0 -> .set(null) in order not to export empty tags since the mapper creates empty collection

    // Lenses count export in json -> @Expose @SerializedName(...) private int lensCount;
    // SELECT distinct / group by p if you want to eliminate repeatables

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
