package app.dto.photographers;

import javax.xml.bind.annotation.*;

/**
 * Created by Venelin on 13.8.2017 г..
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class TrainerXmlImportDto {

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
    private String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    private void setFullName(String fullName) {
        String[] name = fullName.split("\\s+");
        this.firstName = name[0];
        this.lastName = name[1];
    }
}
