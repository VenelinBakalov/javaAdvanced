package app.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by Guest Lector on 17-Jul-17.
 */
@Entity
@DiscriminatorValue(value = "FN")
public class FreshNuke extends BasicShampoos {

}
