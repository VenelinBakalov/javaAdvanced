package models.carriages;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Created by Venelin on 19.7.2017 г..
 */
@Entity
@Table(name = "restaurant_carriages")
@PrimaryKeyJoinColumn(name = "carriage_id")
public class RestaurantCarriage extends Carriage {

    private int tablesCount;

    public RestaurantCarriage() {
    }

    @Column(name = "tables_count")
    public int getTablesCount() {
        return tablesCount;
    }

    public void setTablesCount(int tablesCount) {
        this.tablesCount = tablesCount;
    }
}
