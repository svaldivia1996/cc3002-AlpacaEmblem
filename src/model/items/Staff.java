package model.items;

import model.units.IUnit;

/**
 * This class represents a <i>Staff</i> type item.
 * <p>
 * A staff is an item that can heal other units nut cannot counter any attack
 *
 * @author Ignacio Slater Muñoz
 * @author Sebastian Valdivia Reyes
 * @since 1.0
 */
public class Staff extends AbstractItem {

  /**
   * Creates a new Staff item.
   *
   * @param name
   *     the name of the staff
   * @param power
   *     the healing power of the staff
   * @param minRange
   *     the minimum range of the staff
   * @param maxRange
   *     the maximum range of the staff
   */
  public Staff(final String name, final int power, final int minRange, final int maxRange) {
    super(name, power, minRange, maxRange);
  }

  @Override
  public void equipStaffTo(IUnit unit){
    this.equipTo(unit);
  }

  @Override
  public void attack(IEquipableItem target){
    // Method body intentionally left empty
  }

  @Override
  public void heal(IEquipableItem target){
    double dist = this.getOwner().getLocation().distanceTo(target.getOwner().getLocation());
    if(!this.getOwner().isDead() && dist<=this.getMaxRange() && dist>=this.getMinRange()){
      target.receiveHeal(this);
    }
  }
}
