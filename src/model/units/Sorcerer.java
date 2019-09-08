package model.units;

import model.items.IEquipableItem;
import model.map.Location;

/**
 *This class represents a Sorcerer unit.
 * This unit can use anima, dark and light spells.
 *
 * @author Sebastian Valdivia Reyes
 * @version 1.0
 */
public class Sorcerer extends AbstractUnit {


    /**
     * Creates a new Sorcerer.
     *
     * @param hitPoints the maximum amount of damage a unit can sustain
     * @param movement  the number of panels a unit can move
     * @param location  the current position of this unit on the map
     * @param items the items carried by this unit
     */
    protected Sorcerer(int hitPoints, int movement, Location location, IEquipableItem... items) {
        super(hitPoints, movement, location, 3, items);
    }

    /**
     * Sets the currently equipped item of this unit.
     *
     * @param item
     *     the item to equip
     */
    @Override
    public void equipItem(IEquipableItem item) {
        item.equipAnimaTo(this);
        item.equipDarkTo(this);
        item.equipLightTo(this);

    }
}
