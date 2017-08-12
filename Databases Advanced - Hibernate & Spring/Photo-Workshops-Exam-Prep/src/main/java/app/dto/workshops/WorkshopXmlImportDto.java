package app.dto.workshops;

import app.dto.photographers.ParticipantXmlImportDto;
import app.dto.photographers.TrainerXmlImportDto;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by Venelin on 13.8.2017 г..
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class WorkshopXmlImportDto {

    @XmlAttribute
    private String name;

    @XmlAttribute(name = "start-date")
    private Date startDate;

    @XmlAttribute(name = "end-date")
    private Date endDate;

    @XmlAttribute
    private String location;

    @XmlAttribute(name = "price")
    private BigDecimal pricePerParticipant;

    @XmlElement
    private TrainerXmlImportDto trainer;

    @XmlElementWrapper(name = "participants")
    @XmlElement(name = "participant")
    private List<ParticipantXmlImportDto> participants;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public BigDecimal getPricePerParticipant() {
        return pricePerParticipant;
    }

    public void setPricePerParticipant(BigDecimal pricePerParticipant) {
        this.pricePerParticipant = pricePerParticipant;
    }

    public TrainerXmlImportDto getTrainer() {
        return trainer;
    }

    public void setTrainer(TrainerXmlImportDto trainer) {
        this.trainer = trainer;
    }

    public List<ParticipantXmlImportDto> getParticipants() {
        return participants;
    }

    public void setParticipants(List<ParticipantXmlImportDto> participants) {
        this.participants = participants;
    }
}
