package app.dto.towns;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "towns")
@XmlAccessorType(XmlAccessType.FIELD)
public class TownsWrapperExportXmlDto {

    @XmlElement(name = "town")
    private List<TownExportXmlDto> towns;

    public TownsWrapperExportXmlDto() {
    }

    public List<TownExportXmlDto> getTowns() {
        return towns;
    }

    public void setTowns(List<TownExportXmlDto> towns) {
        this.towns = towns;
    }
}
