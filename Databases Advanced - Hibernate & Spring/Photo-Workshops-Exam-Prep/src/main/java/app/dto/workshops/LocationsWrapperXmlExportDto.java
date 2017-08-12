package app.dto.workshops;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Venelin on 12.8.2017 г..
 */
@XmlRootElement(name = "locations")
@XmlAccessorType(XmlAccessType.FIELD)
public class LocationsWrapperXmlExportDto {

    @XmlElement(name = "location")
    private List<LocationXmlExportDto> locations = new ArrayList<>();

    public List<LocationXmlExportDto> getLocations() {
        return locations;
    }

    public void setLocations(List<LocationXmlExportDto> locations) {
        this.locations = locations;
    }

    public void addLocation(LocationXmlExportDto location) {
        this.locations.add(location);
    }
}
