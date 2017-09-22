package hell.entities.commands;

import hell.entities.Repositories.Repository;
import hell.entities.annotations.Inject;
import hell.entities.factories.Factory;
import hell.interfaces.Hero;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by Venelin on 23.4.2017 г..
 */
public class HeroCommand implements Executable {

    private static final String CREATED_HERO_MESSAGE = "Created %s - %s";

    @Inject private String[] data;
    @Inject private Repository<Hero> heroRepository;
    @Inject private Factory<Hero> heroFactory;

    @Override
    public String execute() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Hero hero = this.heroFactory.create(data);
        this.heroRepository.add(hero);

        return String.format(CREATED_HERO_MESSAGE, hero.getClass().getSimpleName(), hero.getName());
    }
}
