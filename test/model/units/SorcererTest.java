package model.units;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import model.items.Anima;
import model.items.Dark;
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
        sorcerer.addItem(anima);
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
        sorcerer.addItem(dark);
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
        sorcerer.addItem(light);
        sorcerer.equipItem(light);
        assertEquals(light, sorcerer.getEquippedItem());
    }

    @Test
    @Override
    public void normalAttackTest(){
        assertEquals(50,sorcerer.getCurrentHitPoints());
        assertEquals(50,getTargetAlpaca().getCurrentHitPoints());
        sorcerer.addItem(anima);
        sorcerer.equipItem(anima);
        sorcerer.attack(getTargetAlpaca());
        assertEquals(40,getTargetAlpaca().getCurrentHitPoints());
        sorcerer.addItem(dark);
        sorcerer.equipItem(dark);
        sorcerer.attack(getTargetAlpaca());
        assertEquals(30,getTargetAlpaca().getCurrentHitPoints());
        sorcerer.addItem(light);
        sorcerer.equipItem(light);
        sorcerer.attack(getTargetAlpaca());
        assertEquals(20,getTargetAlpaca().getCurrentHitPoints());
    }

    @Test
    @Override
    public void combatTest() {
        Anima anima2 = new Anima("anima",10,1,3);
        getTargetSorcerer().addItem(anima2);
        getTargetSorcerer().equipItem(anima2);
        sorcerer.addItem(anima);
        sorcerer.equipItem(anima);
        getTargetFighter().addItem(axe);
        getTargetFighter().equipItem(axe);
        assertEquals(50,sorcerer.getCurrentHitPoints());
        assertEquals(50,targetSorcerer.getCurrentHitPoints());
        sorcerer.attack(getTargetSorcerer());
        assertEquals(40,sorcerer.getCurrentHitPoints());
        assertEquals(40,targetSorcerer.getCurrentHitPoints());
        getTargetSorcerer().addItem(dark);
        getTargetSorcerer().equipItem(dark);
        sorcerer.attack(getTargetSorcerer());//anima vs dark
        assertEquals(25,sorcerer.getCurrentHitPoints());
        assertEquals(40,targetSorcerer.getCurrentHitPoints());
        getTargetSorcerer().addItem(light);
        getTargetSorcerer().equipItem(light);//anima vs light
        sorcerer.attack(getTargetSorcerer());
        assertEquals(25,sorcerer.getCurrentHitPoints());
        assertEquals(25,targetSorcerer.getCurrentHitPoints());
        sorcerer.attack(getTargetFighter());//anima vs axe
        assertEquals(10,sorcerer.getCurrentHitPoints());
        assertEquals(35,targetFighter.getCurrentHitPoints());
        sorcerer.addItem(light);
        sorcerer.equipItem(light);
        sorcerer.attack(getTargetFighter());//light vs axe
        assertEquals(0,sorcerer.getCurrentHitPoints());
        assertEquals(20,targetFighter.getCurrentHitPoints());
    }

    @Test
    public void CombatTest2(){
        Anima anima2 = new Anima("anima",10,1,3);
        getTargetSorcerer().addItem(anima2);
        getTargetSorcerer().equipItem(anima2);
        sorcerer.addItem(light);
        sorcerer.equipItem(light);
        assertEquals(50,sorcerer.getCurrentHitPoints());
        assertEquals(50,targetSorcerer.getCurrentHitPoints());
        sorcerer.attack(getTargetSorcerer());//light vs anima
        assertEquals(35,sorcerer.getCurrentHitPoints());
        assertEquals(50,targetSorcerer.getCurrentHitPoints());
        getTargetSorcerer().addItem(dark);
        getTargetSorcerer().equipItem(dark);
        sorcerer.attack(getTargetSorcerer());//light vs dark
        assertEquals(35,sorcerer.getCurrentHitPoints());
        assertEquals(35,targetSorcerer.getCurrentHitPoints());


    }
}
