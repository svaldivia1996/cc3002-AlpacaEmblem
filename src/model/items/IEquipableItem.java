package model.items;

import model.units.IUnit;

/**
 * This interface represents the <i>weapons</i> that the units of the game can use.
 * <p>
 * The signature for all the common methods of the weapons are defined here. Every weapon have a
 * base damage and is strong or weak against other type of weapons.
 *
 * @author Ignacio Slater Muñoz
 * @author Sebastian Valdivia Reyes
 * @since 1.0
 */
public interface IEquipableItem {

  /**
   * Equips this item to a unit.
   *
   * @param unit
   *     the unit that will be quipped with the item
   */
  void equipTo(IUnit unit);

  /**
   * @return the unit that has currently equipped this item
   */
  IUnit getOwner();

  /**
   * @return the name of the item
   */
  String getName();

  /**
   * @return the power of the item
   */
  int getPower();

  /**
   * @return the minimum range of the item
   */
  int getMinRange();

  /**
   * @return the maximum range of the item
   */
  int getMaxRange();

  /**
   * Receives a Axe attack.
   * @param axe which is used to attack.
   */
  void receiveAxeAttack(Axe axe);

  /**
   * Receives a sword attack.
   * @param sword which is used to attack.
   */
  void receiveSwordAttack(Sword sword);

  /**
   * Receives a spear attack.
   * @param spear which is used to attack.
   */
  void receiveSpearAttack(Spear spear);

  /**
   * Receives a staff attack.
   * @param staff which is used to attack.
   */
  void receiveStaffAttack(Staff staff);

  /**
   * Receives a bow attack.
   * @param bow which is used to attack.
   */
  void receiveBowAttack(Bow bow);

  /**
   * Receives a anima spell attack.
   * @param anima which is used to attack.
   */
  void receiveAnimaAttack(Anima anima);

  /**
   * Receives a dark spell attack.
   * @param dark which is used to attack.
   */
  void receiveDarkAttack(Dark dark);

  /**
   * Receives a light spell attack
   * @param light which is used to attack.
   */
  void receiveLightAttack(Light light);

}
