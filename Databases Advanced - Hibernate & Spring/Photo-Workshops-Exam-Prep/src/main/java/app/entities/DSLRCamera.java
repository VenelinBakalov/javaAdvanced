package app.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by Venelin on 12.8.2017 г..
 */
@Entity
@DiscriminatorValue(value = "DSLR")
public class DSLRCamera extends BasicCamera {

    private static final String CAMERA_TYPE = "DSLR";

    private int maxShutterSpeed;

    @Column(name = "max_shutter_speed ")
    public static String getCameraType() {
        return CAMERA_TYPE;
    }

    @Override
    protected String type() {
        return CAMERA_TYPE;
    }
}
