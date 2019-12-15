package model.items;

import model.Factorys.Item.DarkFactory;
import model.Factorys.Item.IEquipableItemFactory;
import model.map.Location;
import model.units.IUnit;
import model.units.Sorcerer;

/**
 * Test set for dark spells
 * @author Sebastian Valdivia Reyes
 * @since 1.0
 */
public class DarkTest extends AbstractTestItem {
    private Dark dark;
    private DarkFactory darkFactory;
    private Dark wrongDark;
    private Sorcerer sorcerer;

    @Override
    public void setTestItem(){
        expectedName = "dark";
        expectedPower = 10;
        expectedMinRange = 1;
        expectedMaxRange = 3;
        dark = new Dark(expectedName, expectedPower, expectedMinRange, expectedMaxRange);
        darkFactory = new DarkFactory(dark);
    }

    /**
     * Sets up an item with wrong ranges setted.
     */
    @Override
    public void setWrongRangeItem() {
        wrongDark = new Dark("Wrong dark", 0, -1, -2);
    }

    /**
     * Sets the unit that will be equipped with the test item
     */
    @Override
    public void setTestUnit() {
        sorcerer = new Sorcerer(10, 5, new Location(0, 0));
    }

    @Override
    public IEquipableItem getWrongTestItem() {
        return wrongDark;
    }

    @Override
    public IEquipableItem getTestItem() {
        return dark;
    }

    @Override
    public IEquipableItemFactory getTestFactory(){
        return darkFactory;
    }

    /**
     * @return a unit that can equip the item being tested
     */
    @Override
    public IUnit getTestUnit() {
        return sorcerer;
    }


}
