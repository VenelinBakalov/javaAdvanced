/**
 * Created by Venelin on 6.3.2017 г..
 */
public class YoungCoupleWithChildrenHome extends Home{
    private static final double ROOM_ELECTRICITY_COST = 30;
    private static final int ROOM_COUNT = 2;

    public YoungCoupleWithChildrenHome() {
        super(new Room(ROOM_ELECTRICITY_COST, ROOM_COUNT));
    }
}
