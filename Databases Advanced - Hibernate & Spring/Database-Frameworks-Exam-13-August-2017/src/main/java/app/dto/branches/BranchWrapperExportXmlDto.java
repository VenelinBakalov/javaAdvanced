package app.dto.branches;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "branches")
@XmlAccessorType(XmlAccessType.FIELD)
public class BranchWrapperExportXmlDto {

    @XmlElement(name = "branch")
    List<BranchExportXmlDto> branches;

    public BranchWrapperExportXmlDto() {
    }

    public List<BranchExportXmlDto> getBranches() {
        return branches;
    }

    public void setBranches(List<BranchExportXmlDto> branches) {
        this.branches = branches;
    }
}
