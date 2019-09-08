package model.units;

import model.items.Axe;
import model.items.IEquipableItem;
import model.map.Location;

/**
 * This class represents a fighter type unit.
 * A fighter is a unit that can only use axe type weapons.
 *
 * @author Ignacio Slater Muñoz
 * @author Sebastian Valdivia Reyes
 * @since 1.0
 */
public class Fighter extends AbstractUnit {
  /**
   * Creates a new Fighter
   * @param hitPoints maximum hit points of the unit
   * @param movement the amount of cells this unit can move
   * @param location the initial location of this unit
   * @param items the items carried by this unit
   */
  public Fighter(final int hitPoints, final int movement, final Location location,
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
    item.equipAxeTo(this);
    /*if (item instanceof Axe) {
      equippedItem = item;
    }*/
  }
}
