package firstAndReserveTeam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Team {

    private String name;
    private List<Person> firstTeamPlayers;
    private List<Person> reserveTeamPlayers;

    public Team(String name) {
        this.name = name;
        this.firstTeamPlayers = new ArrayList<>();
        this.reserveTeamPlayers = new ArrayList<>();
    }

    public void addPlayer(Person player) {
        if (player.getAge() < 40) {
            this.firstTeamPlayers.add(player);
        } else {
            this.reserveTeamPlayers.add(player);
        }
    }

    public List<Person> getFirstTeamPlayers() {
        return Collections.unmodifiableList(this.firstTeamPlayers);
    }

    public List<Person> getReserveTeamPlayers() {
        return Collections.unmodifiableList(this.reserveTeamPlayers);
    }
}
