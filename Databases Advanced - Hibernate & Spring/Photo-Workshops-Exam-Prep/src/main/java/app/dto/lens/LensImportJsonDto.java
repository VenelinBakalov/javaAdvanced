package app.dto.lens;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;

/**
 * Created by Venelin on 12.8.2017 г..
 */
public class LensImportJsonDto {

    @Expose
    private String make;

    @Expose
    private Integer focalLength;

    @Expose
    @SerializedName("maxAperture")
    private BigDecimal aperture;

    @Expose
    private String compatibleWith;

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public Integer getFocalLength() {
        return focalLength;
    }

    public void setFocalLength(Integer focalLength) {
        this.focalLength = focalLength;
    }

    public BigDecimal getAperture() {
        return aperture;
    }

    public void setAperture(BigDecimal aperture) {
        this.aperture = aperture;
    }

    public String getCompatibleWith() {
        return compatibleWith;
    }

    public void setCompatibleWith(String compatibleWith) {
        this.compatibleWith = compatibleWith;
    }
}
