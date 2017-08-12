package app.dto.photographers;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Venelin on 12.8.2017 г..
 */
public class LandscapePhotographersJsonDto {

    @Expose
    @SerializedName(value = "FirstName")
    private String firstName;
    @Expose
    @SerializedName(value = "LastName")
    private String lastName;

    @Expose
    @SerializedName(value = "CameraMake")
    private String primaryCameraMake;

    @Expose
    @SerializedName("LensesCount")
    private int lensCount;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPrimaryCameraMake() {
        return primaryCameraMake;
    }

    public void setPrimaryCameraMake(String primaryCameraMake) {
        this.primaryCameraMake = primaryCameraMake;
    }

    public int getLensCount() {
        return lensCount;
    }

    public void setLensCount(int lensCount) {
        this.lensCount = lensCount;
    }
}
