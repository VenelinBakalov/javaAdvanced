package app.dto.photographers;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlValue;

/**
 * Created by Venelin on 12.8.2017 г..
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class ParticipantExportXmlDto {

    @XmlTransient
    private String firstName;

    @XmlTransient
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @XmlValue
    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    public void setFullName(String fullName) {
        String[] names = fullName.split("\\s+");
        this.firstName = names[0];
        this.lastName = names[1];
    }
}
