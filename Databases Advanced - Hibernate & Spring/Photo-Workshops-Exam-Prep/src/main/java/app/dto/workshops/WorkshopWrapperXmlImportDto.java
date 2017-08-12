package app.dto.workshops;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by Venelin on 13.8.2017 г..
 */
@XmlRootElement(name = "workshops")
@XmlAccessorType(XmlAccessType.FIELD)
public class WorkshopWrapperXmlImportDto {

    @XmlElement(name = "workshop")
    List<WorkshopXmlImportDto> workshopXmlImportDtos;

    public List<WorkshopXmlImportDto> getWorkshopXmlImportDtos() {
        return workshopXmlImportDtos;
    }

    public void setWorkshopXmlImportDtos(List<WorkshopXmlImportDto> workshopXmlImportDtos) {
        this.workshopXmlImportDtos = workshopXmlImportDtos;
    }
}
