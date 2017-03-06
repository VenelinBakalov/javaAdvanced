/**
 * Created by Venelin on 6.3.2017 г..
 */
public class AloneYoungHome extends Home {
    private static final double ROOM_ELECTRICITY_COST = 10;
    private static final int ROOM_COUNT = 1;

    public AloneYoungHome() {
        super(new Room(ROOM_ELECTRICITY_COST, ROOM_COUNT));
    }
}
