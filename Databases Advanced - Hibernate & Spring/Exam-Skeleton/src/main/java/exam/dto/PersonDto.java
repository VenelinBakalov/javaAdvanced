package exam.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.xml.bind.annotation.*;
import java.util.Set;

/**
 * Created by Venelin on 6.8.2017 г..
 */
@XmlRootElement(name = "person")
@XmlAccessorType(XmlAccessType.FIELD)
public class PersonDto {

    @Expose
    @XmlElement(name = "first_name")
    private String firstName;

    @Expose
    @SerializedName(value = "phoneJsonDtos")
    @XmlElementWrapper(name = "phone_numbers")
    @XmlElement(name = "phone_number")
    private Set<PersonDto> phoneNumbers;

//    @XmlTransient
}
