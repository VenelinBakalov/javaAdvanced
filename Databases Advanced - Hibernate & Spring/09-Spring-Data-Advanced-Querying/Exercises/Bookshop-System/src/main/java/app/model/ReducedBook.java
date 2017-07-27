package app.model;

import java.math.BigDecimal;

/**
 * Created by Venelin on 27.7.2017 г..
 */
public interface ReducedBook {

    String getTitle();

    void setTitle(String title);

    EditionType getEditionType();

    void setEditionType(EditionType editionType);

    AgeRestriction getAgeRestriction();

    void setAgeRestriction(AgeRestriction ageRestriction);

    BigDecimal getPrice();

    void setPrice(BigDecimal price);


}
