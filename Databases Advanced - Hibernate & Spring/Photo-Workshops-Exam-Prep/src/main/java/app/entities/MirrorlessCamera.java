package app.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by Venelin on 12.8.2017 г..
 */
@Entity
@DiscriminatorValue("Mirrorless")
public class MirrorlessCamera extends BasicCamera {

    private String maxVideoResolution;
    private int maxFrameRate;

    @Column(name = "max_video_resolution")
    public String getMaxVideoResolution() {
        return maxVideoResolution;
    }

    public void setMaxVideoResolution(String maxVideoResolution) {
        this.maxVideoResolution = maxVideoResolution;
    }

    @Column(name = "max_frame_rate")
    public int getMaxFrameRate() {
        return maxFrameRate;
    }

    public void setMaxFrameRate(int maxFrameRate) {
        this.maxFrameRate = maxFrameRate;
    }

    @Override
    protected String type() {
        return "Mirrorless";
    }
}
