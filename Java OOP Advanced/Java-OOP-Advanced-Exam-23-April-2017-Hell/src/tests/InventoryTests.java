package tests;

import hell.entities.miscellaneous.HeroInventory;
import hell.entities.miscellaneous.ItemCollection;
import hell.interfaces.Hero;
import hell.interfaces.Inventory;
import hell.interfaces.Item;
import hell.interfaces.Recipe;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.lang.reflect.Field;
import java.util.*;

/**
 * Created by Venelin on 23.4.2017 г..
 */
public class InventoryTests {

    private Inventory inventory;
    private Item mockedItem;
    private Recipe mockedRecipe;

    @Before
    public void initialize() throws IllegalAccessException {
        this.inventory = new HeroInventory();
        this.mockedItem = Mockito.mock(Item.class);
        this.mockedRecipe = Mockito.mock(Recipe.class);
    }

    @Test
    public void instantiatingInventoryShouldNotThrowException() {
        Inventory inventory = new HeroInventory();
    }

    @Test(expected = NullPointerException.class)
    public void addNullItemShouldThrowException() {
        this.inventory.addCommonItem(null);
    }

    @Test(expected = NullPointerException.class)
    public void addNullRecipeShouldThrowException() {
        this.inventory.addRecipeItem(null);
    }

    @Test
    public void emptyCollectionShouldReturnZero() {
        Assert.assertEquals(0, this.inventory.getTotalStrengthBonus());
        Assert.assertEquals(0, this.inventory.getTotalAgilityBonus());
        Assert.assertEquals(0, this.inventory.getTotalIntelligenceBonus());
        Assert.assertEquals(0, this.inventory.getTotalHitPointsBonus());
        Assert.assertEquals(0, this.inventory.getTotalDamageBonus());
    }

    @Test
    public void addingItemShouldGiveAllCorrectResults() {
        Mockito.when(this.mockedItem.getStrengthBonus()).thenReturn(10);
        Mockito.when(this.mockedItem.getAgilityBonus()).thenReturn(20);
        Mockito.when(this.mockedItem.getIntelligenceBonus()).thenReturn(30);
        Mockito.when(this.mockedItem.getHitPointsBonus()).thenReturn(40);
        Mockito.when(this.mockedItem.getDamageBonus()).thenReturn(50);

        this.inventory.addCommonItem(this.mockedItem);

        Assert.assertEquals(10, this.inventory.getTotalStrengthBonus());
        Assert.assertEquals(20, this.inventory.getTotalAgilityBonus());
        Assert.assertEquals(30, this.inventory.getTotalIntelligenceBonus());
        Assert.assertEquals(40, this.inventory.getTotalHitPointsBonus());
        Assert.assertEquals(50, this.inventory.getTotalDamageBonus());
    }

    @Test
    public void addingValuesShouldReturnCorrectResult() {

        Item itemOne = Mockito.mock(Item.class);
        Mockito.when(itemOne.getStrengthBonus()).thenReturn(10);
        Mockito.when(itemOne.getName()).thenReturn("Gosho");

        Item item = Mockito.mock(Item.class);
        Mockito.when(item.getStrengthBonus()).thenReturn(20);
        Mockito.when(item.getName()).thenReturn("Pesho");
        this.inventory.addCommonItem(itemOne);
        this.inventory.addCommonItem(item);
        Assert.assertEquals(30, this.inventory.getTotalStrengthBonus());
    }
    @Test
    public void addingLongValueShouldReturnCorrectResult() {
        Mockito.when(this.mockedItem.getStrengthBonus()).thenReturn(2000000);
        Mockito.when(this.mockedItem.getName()).thenReturn("Gosho");

        Item item = Mockito.mock(Item.class);
        Mockito.when(item.getStrengthBonus()).thenReturn(1000000);
        Mockito.when(item.getName()).thenReturn("Pesho");
        this.inventory.addCommonItem(this.mockedItem);
        this.inventory.addCommonItem(item);
        Assert.assertEquals(3000000, this.inventory.getTotalStrengthBonus());
    }

    @Test
    public void collectionSizeShouldBeZeroAfterInstantiation() throws NoSuchFieldException, IllegalAccessException {
        Field commonItems = this.inventory.getClass().getDeclaredField("commonItems");
        commonItems.setAccessible(true);
        Map<String, Item> commonMap = (Map<String, Item>) commonItems.get(this.inventory);
        Field recipeItems = this.inventory.getClass().getDeclaredField("recipeItems");
        recipeItems.setAccessible(true);
        Map<String, Recipe> recipeMap = (Map<String, Recipe>) recipeItems.get(this.inventory);
        Assert.assertEquals("Incorrect items count", 0, commonMap.size());
        Assert.assertEquals("Incorrect items count", 0, recipeMap.size());
    }

    @Test
    public void addingNewRecipeShouldIncreaseItemsSize() throws NoSuchFieldException, IllegalAccessException {
        this.inventory.addRecipeItem(this.mockedRecipe);
        Field field = this.inventory.getClass().getDeclaredField("recipeItems");
        field.setAccessible(true);
        Map<String, Recipe> recipeMap = (Map<String, Recipe>) field.get(this.inventory);
        Assert.assertEquals("Incorrect items count", 1, recipeMap.size());
    }

    @Test
    public void addingNewCommonShouldIncreaseItemsSize() throws NoSuchFieldException, IllegalAccessException {
        this.inventory.addRecipeItem(this.mockedRecipe);
        Field field = this.inventory.getClass().getDeclaredField("commonItems");
        field.setAccessible(true);
        Map<String, Item> recipeMap = (Map<String, Item>) field.get(this.inventory);
        Assert.assertEquals("Incorrect items count", 1, recipeMap.size());
    }

    @Test
    public void strengthGetterShouldReturnCorrectResult() {
        Mockito.when(this.mockedItem.getStrengthBonus()).thenReturn(10);
        this.inventory.addCommonItem(this.mockedItem);
        Assert.assertEquals(10, this.inventory.getTotalStrengthBonus());
    }

    @Test
    public void strengthGetterShouldReturnCorrectResultWhenAddingTwoItems() {
        Mockito.when(this.mockedItem.getStrengthBonus()).thenReturn(10);
        Mockito.when(this.mockedItem.getName()).thenReturn("Gosho");

        Item item = Mockito.mock(Item.class);
        Mockito.when(item.getStrengthBonus()).thenReturn(15);
        Mockito.when(item.getName()).thenReturn("Pesho");
        this.inventory.addCommonItem(this.mockedItem);
        this.inventory.addCommonItem(item);
        Assert.assertEquals(25, this.inventory.getTotalStrengthBonus());
    }

    @Test
    public void agilityGetterShouldReturnCorrectResult() {
        Mockito.when(this.mockedItem.getAgilityBonus()).thenReturn(10);
        this.inventory.addCommonItem(this.mockedItem);
        Assert.assertEquals(10, this.inventory.getTotalAgilityBonus());
    }

    @Test
    public void intelligenceGetterShouldReturnCorrectResult() {
        Mockito.when(this.mockedItem.getIntelligenceBonus()).thenReturn(10);
        this.inventory.addCommonItem(this.mockedItem);
        Assert.assertEquals(10, this.inventory.getTotalIntelligenceBonus());
    }

    @Test
    public void hitPointsGetterShouldReturnCorrectResult() {
        Mockito.when(this.mockedItem.getHitPointsBonus()).thenReturn(10);
        this.inventory.addCommonItem(this.mockedItem);
        Assert.assertEquals(10, this.inventory.getTotalHitPointsBonus());
    }

    @Test
    public void damageGetterShouldReturnCorrectResult() {
        Mockito.when(this.mockedItem.getDamageBonus()).thenReturn(10);
        this.inventory.addCommonItem(this.mockedItem);
        Assert.assertEquals(10, this.inventory.getTotalDamageBonus());
    }

    @Test
    public void addingElementShouldGetTheSameElementFromCollection() throws NoSuchFieldException, IllegalAccessException {
        Mockito.when(this.mockedItem.getName()).thenReturn("Gosho");

        this.inventory.addCommonItem(this.mockedItem);
        Field field = this.inventory.getClass().getDeclaredField("commonItems");
        field.setAccessible(true);
        Map<String, Item> recipeMap = (Map<String, Item>) field.get(this.inventory);
        Assert.assertSame(this.mockedItem, recipeMap.get(this.mockedItem.getName()));
    }


    @Test
    public void addingRecipeElementShouldGetTheSameElementFromCollection() throws NoSuchFieldException, IllegalAccessException {
        Mockito.when(this.mockedRecipe.getName()).thenReturn("Gosho");

        this.inventory.addRecipeItem(this.mockedRecipe);
        Field field = this.inventory.getClass().getDeclaredField("recipeItems");
        field.setAccessible(true);
        Map<String, Recipe> recipeMap = (Map<String, Recipe>) field.get(this.inventory);
        Assert.assertSame(this.mockedRecipe, recipeMap.get(this.mockedRecipe.getName()));
    }


    @Test
    public void addingTheSameCommonItemTwiceShouldNotIncreaseCollectionSize() throws NoSuchFieldException, IllegalAccessException {
        this.inventory.addCommonItem(this.mockedItem);
        this.inventory.addCommonItem(this.mockedItem);
        Field field = this.inventory.getClass().getDeclaredField("commonItems");
        field.setAccessible(true);
        Map<String, Item> recipeMap = (Map<String, Item>) field.get(this.inventory);
        Assert.assertEquals("Incorrect items count", 1, recipeMap.size());
    }

    @Test
    public void addingTheSameRecipeItemTwiceShouldNotIncreaseCollectionSize() throws NoSuchFieldException, IllegalAccessException {
        this.inventory.addRecipeItem(this.mockedRecipe);
        this.inventory.addRecipeItem(this.mockedRecipe);
        Field field = this.inventory.getClass().getDeclaredField("recipeItems");
        field.setAccessible(true);
        Map<String, Recipe> recipeMap = (Map<String, Recipe>) field.get(this.inventory);
        Assert.assertEquals("Incorrect items count", 1, recipeMap.size());
    }

//    @Test(expected = IllegalArgumentException.class)
//    public void addingTheSameItemTwiceShouldThrowException() {
//        this.inventory.addCommonItem(this.mockedItem);
//        this.inventory.addCommonItem(this.mockedItem);
//    }
//
//
//    @Test(expected = IllegalArgumentException.class)
//    public void addingTheSameRecipeTwiceShouldThrowException() {
//        Mockito.when(this.mockedRecipe.getName()).thenReturn("Mocked");
//        this.inventory.addRecipeItem(this.mockedRecipe);
//        this.inventory.addRecipeItem(this.mockedRecipe);
//    }

    @Test
    public void addingRecipeShouldNotIncreaseStats() {
        this.inventory.addRecipeItem(this.mockedRecipe);
        Assert.assertEquals(0, this.inventory.getTotalStrengthBonus());
        Assert.assertEquals(0, this.inventory.getTotalAgilityBonus());
        Assert.assertEquals(0, this.inventory.getTotalIntelligenceBonus());
        Assert.assertEquals(0, this.inventory.getTotalHitPointsBonus());
        Assert.assertEquals(0, this.inventory.getTotalDamageBonus());
    }

//    @Test
//    public void addingFullRecipeShouldCombineItAndGetCorrectStatResult() {
//        Mockito.when(this.mockedItem.getName()).thenReturn("Mocked");
//        List<String> mockedRequired = new ArrayList<>();
//        mockedRequired.add("Mocked");
//        Mockito.when(this.mockedRecipe.getRequiredItems()).thenReturn(mockedRequired);
//        Mockito.when(this.mockedRecipe.getName()).thenReturn("MockedRecipe");
//
//        this.inventory.addCommonItem(this.mockedItem);
//        this.inventory.addRecipeItem(this.mockedRecipe);
//
//        Mockito.when(this.mockedItem.getStrengthBonus()).thenReturn(10);
//        Mockito.when(this.mockedRecipe.getStrengthBonus()).thenReturn(20);
//
//        Assert.assertEquals(20, this.inventory.getTotalStrengthBonus());
//    }

}
