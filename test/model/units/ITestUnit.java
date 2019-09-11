package model.units;


import model.items.*;
import model.map.Field;
import org.junit.jupiter.api.Test;

/**
 * Interface that defines the common behaviour of all the test for the units classes
 *
 * @author Ignacio Slater Muñoz*
 * @author Sebastian Valdivia Reyes
 * @since 1.0
 */
public interface ITestUnit {

  /**
   * Set up the game field
   */
  void setField();

  /**
   * Set up the main unit that's going to be tested in the test set
   */
  void setTestUnit();

  /**
   * Set up targetAlpaca
   */
  void setTargetAlpaca();

  /**
   * Set up targethero
   */
  void setTargetHero();

  /**
   * Set up targetFighter
   */
  void setTargetFighter();

  /**
   * Set up targetSwordMaster
   */
  void setTargetSwordMaster();

  /**
   * Set up targetArcher
   */
  void setTargetArcher();

  /**
   * Set up targetSorcerer
   */
  void setTargetSorcerer();

  /**
   * Creates a set of testing weapons
   */
  void setWeapons();

  /**
   * Checks that the constructor works properly.
   */
  @Test
  void constructorTest();

  /**
   * @return the current unit being tested
   */
  IUnit getTestUnit();

  /**
   * Checks if the axe is equipped correctly to the unit
   */
  @Test
  void equipAxeTest();

  /**
   * Tries to equip a weapon to the alpaca and verifies that it was not equipped
   * @param item to be equipped
   */
  void checkEquippedItem(IEquipableItem item);

  /**
   * @return the test axe
   */
  Axe getAxe();

  @Test
  void equipSwordTest();

  /**
   * @return the test sword
   */
  Sword getSword();

  @Test
  void equipSpearTest();

  /**
   * @return the test spear
   */
  Spear getSpear();

  @Test
  void equipStaffTest();

  /**
   * @return the test staff
   */
  Staff getStaff();

  @Test
  void equipBowTest();

  /**
   * @return the test bow
   */
  Bow getBow();

  /**
   * Checks if the unit trades correctly
   */
  @Test
  void TestTrade();

  /**
   * Checks if the unit moves correctly
   */
  @Test
  void testMovement();

  /**
   * @return the test field
   */
  Field getField();

  /**
   * @return the target Alpaca
   */
  Alpaca getTargetAlpaca();

  /**
   * @return the target Hero
   */
  Hero getTargetHero();

  /**
   * @return the target Fighter
   */
  Fighter getTargetFighter();

  /**
   * @return the target SwordMaster
   */
  SwordMaster getTargetSwordMaster();

  /**
   * @return the target Archer
   */
  Archer getTargetArcher();

  /**
   * @return the target Sorcerer
   */
  Sorcerer getTargetSorcerer();


  @Test
  void equipAnimaTest();

  /**
   *
   * @return the test Anima
   */
  Anima getAnima();

  @Test
  void equipDarkTest();

  /**
   *
   * @return the test Dark
   */
  Dark getDark();

  @Test
  void equipLightTest();

  /**
   *
   * @return the test Light
   */
  Light getLight();


  @Test
  void normalAttackTest();

  @Test
  void combatTest();
}
