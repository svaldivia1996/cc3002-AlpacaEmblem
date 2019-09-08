package model.units;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

/**
 * Test set for the sorcerer unit
 *
 * @author Sebastian Valdivia Reyes
 * @since 1.0
 */
public class SorcererTest extends AbstractTestUnit{

    private Sorcerer sorcerer;

    /**
     * Set up the main unit that's going to be tested in the test set
     */
    @Override
    public void setTestUnit(){
        sorcerer = new Sorcerer(50,2,field.getCell(0, 0));
    }

    /**
     * @return the current unit being tested
     */
    @Override
    public IUnit getTestUnit() {
        return sorcerer;
    }

    /**
     * Checks if the Anima Spell is equipped correctly to the unit
     */
    @Test
    @Override
    public void equipAnimaTest() {
        assertNull(sorcerer.getEquippedItem());
        sorcerer.equipItem(anima);
        assertEquals(anima, sorcerer.getEquippedItem());
    }

    /**
     * Checks if the Dark Spell is equipped correctly to the unit
     */
    @Test
    @Override
    public void equipDarkTest() {
        assertNull(sorcerer.getEquippedItem());
        sorcerer.equipItem(dark);
        assertEquals(dark, sorcerer.getEquippedItem());
    }

    /**
     * Checks if the Light Spell is equipped correctly to the unit
     */
    @Test
    @Override
    public void equipLightTest() {
        assertNull(sorcerer.getEquippedItem());
        sorcerer.equipItem(light);
        assertEquals(light, sorcerer.getEquippedItem());
    }

}
