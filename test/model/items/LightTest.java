package model.items;

import model.Factorys.Item.IEquipableItemFactory;
import model.Factorys.Item.LightFactory;
import model.map.Location;
import model.units.IUnit;
import model.units.Sorcerer;

/**
 * Test set for Light Spells
 * @author Sebastian Valdivia Reyes
 * @since 1.0
 */
public class LightTest extends AbstractTestItem {
    private Light light;
    private LightFactory lightFactory;
    private Light wrongLight;
    private Sorcerer sorcerer;

    @Override
    public void setTestItem(){
        expectedName = "anima";
        expectedPower = 10;
        expectedMinRange = 1;
        expectedMaxRange = 3;
        light = new Light(expectedName, expectedPower, expectedMinRange, expectedMaxRange);
        lightFactory = new LightFactory(light);
    }

    /**
     * Sets up an item with wrong ranges setted.
     */
    @Override
    public void setWrongRangeItem() {
        wrongLight = new Light("Wrong anima", 0, -1, -2);
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
        return wrongLight;
    }

    @Override
    public IEquipableItem getTestItem() {
        return light;
    }

    @Override
    public IEquipableItemFactory getTestFactory(){
        return lightFactory;
    }

    /**
     * @return a unit that can equip the item being tested
     */
    @Override
    public IUnit getTestUnit() {
        return sorcerer;
    }
}
