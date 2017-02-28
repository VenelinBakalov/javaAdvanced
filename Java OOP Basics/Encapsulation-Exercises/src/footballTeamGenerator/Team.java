package footballTeamGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Team {

    private String name;
    private List<Player> players;

    public Team(String name) {
        this.setName(name);
        this.players = new ArrayList<>();
    }

    public double getRating() {
        return this.getPlayers().stream().mapToDouble(Player::getOverallSkillLevel).average().orElse(0);
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void removePlayer(String playerName) {
        Player player = this.getPlayers().stream().filter(p -> playerName.equals(p.getName())).findAny().orElse(null);
        if (player == null) {
            throw new IllegalArgumentException(String.format("Player %s is not in %s team.", playerName, this.getName()));
        }
        this.players.remove(player);
    }

    @Override
    public String toString() {
        return String.format("%s - %.0f", this.getName(), this.getRating());
    }

    private String getName() {
        return name;
    }

    private void setName(String name) {
        if (name == null || name.trim().length() == 0) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    private List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }
}
