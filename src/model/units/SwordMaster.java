package model.units;

import model.items.IEquipableItem;
import model.map.Location;

/**
 * This class represents a <i>SwordMaster</i> type unit.
 * <p>
 * A <i>SwordMaster</i> is a unit that <b>can only use sword type weapons</b>.
 *
 * @author Sebastian Valdivia Reyes
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public class SwordMaster extends AbstractUnit {

  /**
   *
   * @param hitPoints the maximum amount of damage a unit can sustain
   * @param movement the number of panels a unit can move
   * @param location the current position of this unit on the map
   * @param items the items carried by this unit
   */
  public SwordMaster(final int hitPoints, final int movement, final Location location,
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
      item.equipSwordTo(this);
    }
  }
}
