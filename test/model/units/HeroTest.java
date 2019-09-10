package model.units;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import model.items.Spear;
import org.junit.jupiter.api.Test;

/**
 * Test set for the alpaca unit
 * @author Ignacio Slater Muñoz
 * @author Sebastian Valdivia Reyes
 * @since 1.0
 */
public class HeroTest extends AbstractTestUnit {

  private Hero hero;

  /**
   * Set up the main unit that's going to be tested in the test set
   */
  @Override
  public void setTestUnit() {
    hero = new Hero(50, 2, field.getCell(0, 0));
  }

  /**
   * @return the current unit being tested
   */
  @Override
  public IUnit getTestUnit() {
    return hero;
  }

  @Override
  @Test
  public void equipSpearTest() {
    assertNull(hero.getEquippedItem());
    hero.equipItem(spear);
    assertEquals(spear, hero.getEquippedItem());
  }

  @Test
  @Override
  public void normalAttackTest(){
    hero.equipItem(spear);
    assertEquals(50,hero.getCurrentHitPoints());
    assertEquals(50,getTargetHero().getCurrentHitPoints());
    hero.attack(getTargetHero());
    assertEquals(40,getTargetHero().getCurrentHitPoints());
    assertEquals(50,hero.getCurrentHitPoints());
  }

  @Test
  @Override
  public void combatTest(){
    Spear spear2 = new Spear("Spear", 10, 1, 2);
    hero.equipItem(spear);
    getTargetHero().equipItem(spear2);
    assertEquals(50,hero.getCurrentHitPoints());
    assertEquals(50,getTargetHero().getCurrentHitPoints());
    hero.attack(getTargetHero());
    assertEquals(40,getTargetHero().getCurrentHitPoints());
    assertEquals(40,hero.getCurrentHitPoints());
  }
}