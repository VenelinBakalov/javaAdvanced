package app.homes;

import app.Room;

/**
 * Created by Venelin on 6.3.2017 г..
 */
public class YoungCoupleHome extends Home {

    private static final double ROOM_ELECTRICITY_COST = 20;
    private static final int ROOM_COUNT = 2;

    public YoungCoupleHome() {
        super(new Room(ROOM_ELECTRICITY_COST, ROOM_COUNT));
    }
}
