package app.dto.accessories;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

/**
 * Created by Venelin on 13.8.2017 г..
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class AccessoryXmlImportDto {

    @XmlAttribute
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
