package model.units;

import model.items.IEquipableItem;
import model.items.Staff;
import model.map.Location;

/**
 * This class represents a cleric type unit. A cleric can only use staff type weapons, which means
 * that it can receive attacks but can't counter attack any of those.
 *
 * @author Ignacio Slater Muñoz
 * @author Sebastian valdivia Reyes
 * @since 1.0
 */
public class Cleric extends AbstractUnit {

  /**
   * Creates a new Cleric.
   *
   * @param hitPoints
   *     the maximum amount of damage a unit can sustain
   * @param movement
   *     the number of panels a unit can move
   * @param location the initial location of this unit
   * @param items the items carried by this unit
   */
  public Cleric(final int hitPoints, final int movement, final Location location,
      IEquipableItem... items) {
    super(hitPoints, movement, location, 3, items);
  }

  /**
   * Sets the currently equipped item of this unit.
   *
   * @param item
   *     the item to equip
   */
  @Override
  public void equipItem(final IEquipableItem item) {
    if (this.getItems().contains(item)) {
      item.equipStaffTo(this);
    }
  }

  @Override
  public void attack(IUnit unit){
    // Method body intentionally left empty
  }
}
