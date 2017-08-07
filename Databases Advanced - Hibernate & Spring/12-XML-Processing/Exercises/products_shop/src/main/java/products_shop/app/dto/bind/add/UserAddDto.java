package products_shop.app.dto.bind.add;

import com.google.gson.annotations.Expose;

import javax.xml.bind.annotation.*;


@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserAddDto {

    @Expose
    @XmlAttribute(name = "first-name")
    private String firstName;

    @Expose
    @XmlAttribute(name = "last-name")
    private String lastName;

    @Expose
    @XmlAttribute(name = "age")
    private Integer age;

    public UserAddDto() {
    }

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
