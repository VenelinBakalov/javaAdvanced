package hell.entities.commands;

import hell.entities.Repositories.Repository;
import hell.entities.annotations.Inject;
import hell.entities.items.CommonItem;
import hell.interfaces.Hero;
import hell.interfaces.Item;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by Venelin on 23.4.2017 г..
 */
public class ItemCommand implements Executable {

    private static final String ADDED_ITEM_TO_HERO_MESSAGE = "Added item - %s to Hero - %s";

    @Inject private String[] data;
    @Inject private Repository<Hero> heroRepository;

    @Override
    public String execute() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        String itemName = this.data[0];
        String heroName = this.data[1];
        int strengthBonus = Integer.parseInt(this.data[2]);
        int agilityBonus = Integer.parseInt(this.data[3]);
        int intelligenceBonus = Integer.parseInt(this.data[4]);
        int hitPointsBonus = Integer.parseInt(this.data[5]);
        int damageBonus = Integer.parseInt(this.data[6]);

        Item item = new CommonItem(itemName, strengthBonus, agilityBonus, intelligenceBonus, hitPointsBonus, damageBonus);

        this.heroRepository.get(heroName).addItem(item);


        return String.format(ADDED_ITEM_TO_HERO_MESSAGE, item.getName(), heroName);
    }
}
