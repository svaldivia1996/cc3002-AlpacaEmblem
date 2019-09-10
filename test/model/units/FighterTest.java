package model.units;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import model.items.Axe;
import org.junit.jupiter.api.Test;

/**
 * @author Ignacio Slater Muñoz
 */
public class FighterTest extends AbstractTestUnit {

  private Fighter fighter;

  /**
   * Set up the main unit that's going to be tested in the test set
   */
  @Override
  public void setTestUnit() {
    fighter = new Fighter(50, 2, field.getCell(0, 0));
  }

  /**
   * @return the current unit being tested
   */
  @Override
  public IUnit getTestUnit() {
    return fighter;
  }

  /**
   * Checks if the axe is equipped correctly to the unit
   */
  @Test
  @Override
  public void equipAxeTest() {
    assertNull(fighter.getEquippedItem());
    fighter.equipItem(axe);
    assertEquals(axe, fighter.getEquippedItem());
  }


  @Test
  @Override
  public void normalAttackTest(){
    fighter.equipItem(axe);
    assertEquals(50,fighter.getCurrentHitPoints());
    assertEquals(50,getTargetHero().getCurrentHitPoints());
    fighter.attack(getTargetHero());
    assertEquals(40,getTargetHero().getCurrentHitPoints());
    assertEquals(50,fighter.getCurrentHitPoints());
  }

  @Test
  @Override
  public void combatTest(){
    Axe axe2= new Axe("axe", 10, 1, 2);
    fighter.equipItem(axe);
    getTargetFighter().equipItem(axe2);
    getTargetSwordMaster().equipItem(sword);
    getTargetHero().equipItem(spear);
    getTargetSorcerer().equipItem(anima);
    assertEquals(50, fighter.getCurrentHitPoints());
    assertEquals(50, getTargetFighter().getCurrentHitPoints());
    assertEquals(50, getTargetSwordMaster().getCurrentHitPoints());
    fighter.attack(getTargetFighter());//Fighter vs Fighter
    assertEquals(40, getTargetFighter().getCurrentHitPoints());
    assertEquals(40, fighter.getCurrentHitPoints());
    fighter.attack(getTargetSwordMaster());//Fighter vs SwordMaster
    assertEquals(25, fighter.getCurrentHitPoints());
    assertEquals(50, getTargetSwordMaster().getCurrentHitPoints());
    fighter.attack(getTargetHero());//Fighter vs Hero
    assertEquals(25, fighter.getCurrentHitPoints());
    assertEquals(35, getTargetHero().getCurrentHitPoints());
    fighter.attack(getTargetSorcerer());//Axe vs Anima
    assertEquals(10, fighter.getCurrentHitPoints());
    assertEquals(35, getTargetHero().getCurrentHitPoints());
    getTargetSorcerer().equipItem(dark);
    fighter.attack(getTargetSorcerer());//Axe vs Dark
    assertEquals(-5, fighter.getCurrentHitPoints());//Caso Borde
    assertEquals(20, getTargetSorcerer().getCurrentHitPoints());
  }
}