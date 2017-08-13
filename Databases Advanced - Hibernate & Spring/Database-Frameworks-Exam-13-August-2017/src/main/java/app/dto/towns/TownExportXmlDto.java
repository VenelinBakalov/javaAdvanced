package app.dto.towns;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class TownExportXmlDto {

    @XmlAttribute
    private String name;

    @XmlAttribute
    private Integer population;

    @XmlAttribute(name = "town_clients")
    private Integer townClients;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public Integer getTownClients() {
        return townClients;
    }

    public void setTownClients(Integer townClients) {
        this.townClients = townClients;
    }
}
