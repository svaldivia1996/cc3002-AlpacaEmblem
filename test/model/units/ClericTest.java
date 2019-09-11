package model.units;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import model.items.Staff;
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
    cleric.addItem(staff);
    cleric.equipItem(staff);
    assertEquals(staff, cleric.getEquippedItem());
  }

  @Test
  @Override
  public void normalAttackTest() {
    cleric.addItem(staff);
    cleric.equipItem(staff);
    getTargetHero().addItem(spear);
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
    Cleric cleric2 = new Cleric(50,3,field.getCell(1, 0));
    Staff staff2 = new Staff("Staff", 10, 1, 2);
    cleric2.addItem(staff2);
    cleric2.equipItem(staff2);
    cleric.addItem(staff);
    cleric.equipItem(staff);
    assertEquals(50,cleric.getCurrentHitPoints());
    assertEquals(50,getTargetAlpaca().getCurrentHitPoints());
    cleric.attack(getTargetAlpaca());
    assertEquals(50,getTargetAlpaca().getCurrentHitPoints());
    staff.attack(staff2);//The only way to "force" a staff attack
    assertEquals(50,cleric.getCurrentHitPoints());
    assertEquals(50,cleric2.getCurrentHitPoints());
    cleric.heal(cleric2);//Trying to OverHeal
    assertEquals(50,cleric.getCurrentHitPoints());
    assertEquals(50,cleric2.getCurrentHitPoints());
    targetFighter.addItem(axe);
    targetFighter.equipItem(axe);
    targetFighter.setLocation(getField().getCell(0,0));
    targetFighter.attack(cleric2);//
    assertEquals(40,cleric2.getCurrentHitPoints());
    cleric.heal(cleric2);//normal heal
    assertEquals(50,cleric2.getCurrentHitPoints());
    getTargetHero().addItem(spear);
    getTargetHero().equipItem(spear);
    targetFighter.attack(targetHero);
    assertEquals(50,targetFighter.getCurrentHitPoints());
    assertEquals(35,targetHero.getCurrentHitPoints());
    cleric.heal(targetFighter);
    cleric.heal(targetHero);
    assertEquals(50,targetFighter.getCurrentHitPoints());
    assertEquals(45,targetHero.getCurrentHitPoints());

  }
}