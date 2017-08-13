package app.dto.employeeCards;

import com.google.gson.annotations.Expose;

public class EmployeeCardImportJsonDto {

    @Expose
    private String number;

    public EmployeeCardImportJsonDto() {
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
