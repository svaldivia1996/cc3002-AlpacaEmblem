package model.units;

import model.items.Sword;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * @author Ignacio Slater Muñoz
 */
public class SwordMasterTest extends AbstractTestUnit {

  private SwordMaster swordMaster;

  /**
   * Set up the main unit that's going to be tested in the test set
   */
  @Override
  public void setTestUnit() {
    swordMaster = new SwordMaster(50, 2, field.getCell(0, 0));
  }

  /**
   * @return the current unit being tested
   */
  @Override
  public IUnit getTestUnit() {
    return swordMaster;
  }

  @Test
  @Override
  public void equipSwordTest() {
    assertNull(swordMaster.getEquippedItem());
    swordMaster.equipItem(sword);
    assertEquals(sword, swordMaster.getEquippedItem());
  }

  @Test
  @Override
  public void normalAttackTest(){
    swordMaster.equipItem(sword);
    assertEquals(50,swordMaster.getCurrentHitPoints());
    assertEquals(50,getTargetHero().getCurrentHitPoints());
    swordMaster.attack(getTargetHero());
    assertEquals(40,getTargetHero().getCurrentHitPoints());
    assertEquals(50,swordMaster.getCurrentHitPoints());
  }

  @Test
  @Override
  public void combatTest(){
    Sword sword2 = new Sword("Sword",10,1,2);
    swordMaster.equipItem(sword);
    getTargetSwordMaster().equipItem(sword2);
    assertEquals(50,swordMaster.getCurrentHitPoints());
    assertEquals(50,getTargetSwordMaster().getCurrentHitPoints());
    swordMaster.attack(getTargetSwordMaster());
    assertEquals(40,getTargetSwordMaster().getCurrentHitPoints());
    assertEquals(40,swordMaster.getCurrentHitPoints());
  }
}