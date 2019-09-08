package model.items;

import model.map.Location;
import model.units.IUnit;
import model.units.Sorcerer;

/**
 * Test set for Anima Spells
 * @author Sebastian Valdivia Reyes
 * @since 1.0
 */
public class AnimaTest extends AbstractTestItem {

    private Anima anima;
    private Anima wrongAnima;
    private Sorcerer sorcerer;

    @Override
    public void setTestItem(){
        expectedName = "anima";
        expectedPower = 10;
        expectedMinRange = 1;
        expectedMaxRange = 3;
        anima = new Anima(expectedName, expectedPower, expectedMinRange, expectedMaxRange);
    }

    /**
     * Sets up an item with wrong ranges setted.
     */
    @Override
    public void setWrongRangeItem() {
        wrongAnima = new Anima("Wrong anima", 0, -1, -2);
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
        return wrongAnima;
    }

    @Override
    public IEquipableItem getTestItem() {
        return anima;
    }

    /**
     * @return a unit that can equip the item being tested
     */
    @Override
    public IUnit getTestUnit() {
        return sorcerer;
    }
}
