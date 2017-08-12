package app.dto.workshops;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * Created by Venelin on 12.8.2017 г..
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class LocationXmlExportDto {

    @XmlAttribute
    private String name;

    @XmlElement(name = "workshop")
    private List<WorkshopExportXmlDto> workshops;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<WorkshopExportXmlDto> getWorkshops() {
        return workshops;
    }

    public void setWorkshops(List<WorkshopExportXmlDto> workshops) {
        this.workshops = workshops;
    }
}
