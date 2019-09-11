package model.units;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import model.items.Bow;
import org.junit.jupiter.api.Test;

/**
 * Test set for the Archer unit.
 *
 * @author Ignacio Slater Muñoz
 * @author Sebastian Valdivia Reyes
 * @since 1.0
 */
public class ArcherTest extends AbstractTestUnit {

  private Archer archer;

  /**
   * Set up the main unit that's going to be tested in the test set
   */
  @Override
  public void setTestUnit() {
    archer = new Archer(50, 2, field.getCell(0, 0));
  }

  /**
   * @return the current unit being tested
   */
  @Override
  public IUnit getTestUnit() {
    return archer;
  }

  /**
   * Checks if the bow is equipped correctly to the unit
   */
  @Test
  @Override
  public void equipBowTest() {
    assertNull(archer.getEquippedItem());
    archer.addItem(bow);
    archer.equipItem(bow);
    assertEquals(bow, archer.getEquippedItem());
  }

  /**
   * The archer cannot attack adjacent enemies
   */
  @Test
  public void adjacentAttackTest(){
    archer.addItem(bow);
    archer.equipItem(bow);
    assertEquals(50,archer.getCurrentHitPoints());
    assertEquals(50,getTargetAlpaca().getCurrentHitPoints());
    archer.attack(getTargetAlpaca());
    assertEquals(50,getTargetAlpaca().getCurrentHitPoints());
  }

  @Test
  @Override
  public void normalAttackTest(){
    archer.addItem(bow);
    archer.equipItem(bow);
    getTargetAlpaca().setLocation(getField().getCell(0,2));
    assertEquals(50,archer.getCurrentHitPoints());
    assertEquals(50,getTargetAlpaca().getCurrentHitPoints());
    archer.attack(getTargetAlpaca());
    assertEquals(40,getTargetAlpaca().getCurrentHitPoints());
  }

  @Override
  public  void combatTest(){
    Bow bow2 = new Bow("Bow", 10, 2, 3);
    archer.addItem(bow);
    archer.equipItem(bow);
    getTargetArcher().addItem(bow2);
    getTargetArcher().equipItem(bow2);
    assertEquals(50,archer.getCurrentHitPoints());
    assertEquals(50,getTargetArcher().getCurrentHitPoints());
    archer.attack(getTargetArcher());//bow vs bow
    assertEquals(40,archer.getCurrentHitPoints());
    assertEquals(40,getTargetArcher().getCurrentHitPoints());
    getTargetHero().setLocation(getField().getCell(0,2));
    getTargetHero().addItem(spear);
    getTargetHero().equipItem(spear);
    archer.attack(getTargetHero());//bow vs spear out of range
    assertEquals(40,archer.getCurrentHitPoints());
    assertEquals(40,getTargetHero().getCurrentHitPoints());

  }
}