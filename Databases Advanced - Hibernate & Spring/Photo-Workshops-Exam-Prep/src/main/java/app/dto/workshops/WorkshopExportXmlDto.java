package app.dto.workshops;

import app.dto.photographers.ParticipantsWrapperExportXmlDto;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;

/**
 * Created by Venelin on 12.8.2017 г..
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class WorkshopExportXmlDto {

    @XmlAttribute
    private String name;

    @XmlElement(name = "participants")
    private ParticipantsWrapperExportXmlDto participants;

    @XmlTransient
    private BigDecimal pricePerParticipant;

    @XmlAttribute(name = "total-profit")
    public String getTotalProfit() {
        return String.valueOf(pricePerParticipant
                .multiply(BigDecimal.valueOf(participants.getCount()))
                .multiply(BigDecimal.valueOf(0.8)));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ParticipantsWrapperExportXmlDto getParticipants() {
        return participants;
    }

    public void setParticipants(ParticipantsWrapperExportXmlDto participants) {
        this.participants = participants;
    }

    public BigDecimal getPricePerParticipant() {
        return pricePerParticipant;
    }

    public void setPricePerParticipant(BigDecimal pricePerParticipant) {
        this.pricePerParticipant = pricePerParticipant;
    }
}
