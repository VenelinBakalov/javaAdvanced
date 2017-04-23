package hell.entities.Repositories;

import hell.interfaces.Hero;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Venelin on 23.4.2017 г..
 */
public class HeroRepository implements Repository<Hero> {

    private Map<String, Hero> heroes;

    public HeroRepository() {
        this.heroes = new LinkedHashMap<>();
    }

    @Override
    public void add(Hero hero) {
        this.heroes.put(hero.getName(), hero);
    }

    @Override
    public void remove(Hero hero) {
        this.heroes.remove(hero.getName());
    }

    @Override
    public Hero get(String heroName) {
        return this.heroes.get(heroName);
    }

    @Override
    public Collection<Hero> getAll() {
        return this.heroes.values();
    }

}
