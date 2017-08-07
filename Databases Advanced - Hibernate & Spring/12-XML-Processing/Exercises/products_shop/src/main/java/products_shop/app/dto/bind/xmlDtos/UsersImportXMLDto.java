package products_shop.app.dto.bind.xmlDtos;

import products_shop.app.dto.bind.add.UserAddDto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by Venelin on 7.8.2017 г..
 */
@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UsersImportXMLDto {

    @XmlElement(name = "user")
    List<UserAddDto> userAddDtos;

    public UsersImportXMLDto() {
    }

    public List<UserAddDto> getUserAddDtos() {
        return userAddDtos;
    }

    public void setUserAddDtos(List<UserAddDto> userAddDtos) {
        this.userAddDtos = userAddDtos;
    }
}
