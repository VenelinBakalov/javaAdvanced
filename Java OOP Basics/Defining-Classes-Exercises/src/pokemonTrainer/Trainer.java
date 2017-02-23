package pokemonTrainer;


import java.util.HashSet;
import java.util.Set;

public class Trainer {
    private static final int INITIAL_BADGE_COUNT = 0;

    private String name;
    private int badgeCount;
    private Set<Pokemon> pokemons;

    public Trainer(String name) {
        this.name = name;
        this.badgeCount = INITIAL_BADGE_COUNT;
        this.pokemons = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBadgeCount() {
        return badgeCount;
    }

    public void setBadgeCount(int badgeCount) {
        this.badgeCount = badgeCount;
    }

    public Set<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(Set<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    @Override
    public String toString() {
        return String.format("%s %d %d", this.name, this.badgeCount, this.pokemons.size());
    }
}
