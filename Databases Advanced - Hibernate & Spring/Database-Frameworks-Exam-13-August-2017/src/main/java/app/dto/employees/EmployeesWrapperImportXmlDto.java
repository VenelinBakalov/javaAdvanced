package app.dto.employees;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "employees")
@XmlAccessorType(XmlAccessType.FIELD)
public class EmployeesWrapperImportXmlDto {

    @XmlElement(name = "employee")
    private List<EmployeeImportXmlDto> employees;

    public EmployeesWrapperImportXmlDto() {
    }

    public List<EmployeeImportXmlDto> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeImportXmlDto> employees) {
        this.employees = employees;
    }
}
