package app.dto.employees;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.persistence.Transient;

public class EmployeeExportJsonDto {

    @Expose
    @SerializedName("full_name")
    private String fullName;

    @Expose
    private String position;

    @Expose
    @SerializedName("number")
    private String cardNumber;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
}
