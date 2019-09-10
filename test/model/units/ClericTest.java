package model.units;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

/**
 * @author Ignacio Slater Muñoz
 * @author Sebastian Valdivia Reyes
 */
public class ClericTest extends AbstractTestUnit {

  private Cleric cleric;

  /**
   * Set up the main unit that's going to be tested in the test set
   */
  @Override
  public void setTestUnit() {
    cleric = new Cleric(50, 2, field.getCell(0, 0));
  }

  /**
   * @return the current unit being tested
   */
  @Override
  public IUnit getTestUnit() {
    return cleric;
  }

  @Test
  @Override
  public void equipStaffTest() {
    assertNull(cleric.getEquippedItem());
    cleric.equipItem(staff);
    assertEquals(staff, cleric.getEquippedItem());
  }

  @Test
  @Override
  public void normalAttackTest() {
    cleric.equipItem(staff);
    getTargetHero().equipItem(spear);
    assertEquals(50,cleric.getCurrentHitPoints());
    assertEquals(50,getTargetHero().getCurrentHitPoints());
    cleric.attack(getTargetHero());
    assertEquals(50,getTargetHero().getCurrentHitPoints());
    assertEquals(50,cleric.getCurrentHitPoints());
  }

  /**
   * The cleric cannot attack
   */
  @Test
  @Override
  public void combatTest(){
    cleric.equipItem(staff);
    assertEquals(50,cleric.getCurrentHitPoints());
    assertEquals(50,getTargetAlpaca().getCurrentHitPoints());
    cleric.attack(getTargetAlpaca());
    assertEquals(50,getTargetAlpaca().getCurrentHitPoints());
  }
}