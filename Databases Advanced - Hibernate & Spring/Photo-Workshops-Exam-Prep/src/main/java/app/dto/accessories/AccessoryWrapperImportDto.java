package app.dto.accessories;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by Venelin on 13.8.2017 г..
 */
@XmlRootElement(name = "accessories")
@XmlAccessorType(XmlAccessType.FIELD)
public class AccessoryWrapperImportDto {

    @XmlElement(name = "accessory")
    private List<AccessoryXmlImportDto> accessories;

    public List<AccessoryXmlImportDto> getAccessories() {
        return accessories;
    }

    public void setAccessories(List<AccessoryXmlImportDto> accessories) {
        this.accessories = accessories;
    }
}
