/**
 * Created by Venelin on 6.3.2017 г..
 */
public class OldCoupleHome extends Home {
    private static final double ROOM_ELECTRICITY_COST = 15;
    private static final int ROOM_COUNT = 3;

    public OldCoupleHome() {
        super(new Room(ROOM_ELECTRICITY_COST, ROOM_COUNT));
    }
}
