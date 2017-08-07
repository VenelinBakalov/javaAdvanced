package exam.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by Venelin on 6.8.2017 г..
 */
@XmlRootElement(name = "people")
public class PeopleDto {

    private List<PersonDto> personDtos;

    @XmlElement(name = "person")
    public List<PersonDto> getPersonDtos() {
        return personDtos;
    }

    public void setPersonDtos(List<PersonDto> personDtos) {
        this.personDtos = personDtos;
    }
}
