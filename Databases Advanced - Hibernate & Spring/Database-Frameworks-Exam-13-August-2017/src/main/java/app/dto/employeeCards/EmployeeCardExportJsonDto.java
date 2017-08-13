package app.dto.employeeCards;

import com.google.gson.annotations.Expose;

public class EmployeeCardExportJsonDto {

    @Expose
    private String number;

    public EmployeeCardExportJsonDto() {
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
