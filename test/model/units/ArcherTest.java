package model.units;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

/**
 * Test set for the Archer unit.
 *
 * @author Ignacio Slater Muñoz
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
    archer.equipItem(bow);
    assertEquals(bow, archer.getEquippedItem());
  }

  /**
   * The archer cannot attack adjacent enemies
   */
  @Test
  public void adjacentAttackTest(){
    archer.equipItem(bow);
    assertEquals(archer.getCurrentHitPoints(),50);
    assertEquals(getTargetAlpaca().getCurrentHitPoints(),50);
    archer.attack(getTargetAlpaca());
    assertEquals(getTargetAlpaca().getCurrentHitPoints(),50);
  }

  @Test
  @Override
  public void normalAttackTest(){
    archer.equipItem(bow);
    getTargetAlpaca().moveTo(getField().getCell(0,2));
    assertEquals(archer.getCurrentHitPoints(),50);
    assertEquals(getTargetAlpaca().getCurrentHitPoints(),50);
    archer.attack(getTargetAlpaca());
    assertEquals(getTargetAlpaca().getCurrentHitPoints(),40);
  }
}