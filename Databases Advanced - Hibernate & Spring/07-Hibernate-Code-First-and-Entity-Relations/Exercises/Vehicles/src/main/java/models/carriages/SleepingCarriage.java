package models.carriages;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Created by Venelin on 19.7.2017 г..
 */
@Entity
@Table(name = "sleeping_carriages")
@PrimaryKeyJoinColumn(name = "carriage_id")
public class SleepingCarriage extends Carriage {

    private int bedsCount;

    public SleepingCarriage() {
    }

    @Column(name = "beds_count")
    public int getBedsCount() {
        return bedsCount;
    }

    public void setBedsCount(int bedsCount) {
        this.bedsCount = bedsCount;
    }
}
