package app.dto.photographers;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * Created by Venelin on 12.8.2017 г..
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class ParticipantsWrapperExportXmlDto {

    @XmlElement(name = "participant")
    private List<ParticipantExportXmlDto> participants;

    public List<ParticipantExportXmlDto> getParticipants() {
        return participants;
    }

    public void setParticipants(List<ParticipantExportXmlDto> participants) {
        this.participants = participants;
    }

    @XmlElement(name = "count")
    public int getCount() {
        return this.participants.size();
    }
}
