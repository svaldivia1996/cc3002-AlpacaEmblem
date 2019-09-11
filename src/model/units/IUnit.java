package model.units;

import java.util.List;

import model.items.*;
import model.map.Location;

/**
 * This interface represents all units in the game.
 * <p>
 * The signature of all the common methods that a unit can execute are defined here. All units
 * except some special ones can carry at most 3 weapons.
 *
 * @author Ignacio Slater Muñoz
 * @author Sebastian Valdivia Reyes
 * @since 1.0
 */
public interface IUnit {

    /**
     * The current state of the unit, dead or alive.
     * @return True if the unit is dead, false otherwise.
     */
    boolean isDead();

    /**
     * Sets the currently equipped item of this unit.
     *
     * @param item the item to equip
     */
    void equipItem(IEquipableItem item);

    /**
     *
     * @return return the maximum amount of hit points of the unit
     */
    int getMaxHitPoints();

    /**
     * @return the current hit points of the unit
     */
    int getCurrentHitPoints();

    /**
     * @return the items carried by this unit
     */
    List<IEquipableItem> getItems();

    /**
     * @return the currently equipped item
     */
    IEquipableItem getEquippedItem();

    /**
     * @param item the item to be equipped
     */
    void setEquippedItem(IEquipableItem item);

    /**
     * @return the current location of the unit
     */
    Location getLocation();

    /**
     * Sets a new location for this unit,
     */
    void setLocation(final Location location);

    /**
     * @return the number of cells this unit can move
     */
    int getMovement();

    /**
     * Moves this unit to another location.
     * <p>
     * If the other location is out of this unit's movement range, the unit doesn't move.
     */
    void moveTo(Location targetLocation);

    /**
     * Attacks another unit.
     * @param target of the attack.
     */
    void attack(IUnit target);

    /**
     * Heals another unit.
     * @param target of the attack.
     */
    void heal(IUnit target);

    /**
     * Performs a counterattack
     * @param target the unit who does the counter attack
     */
    void counterAttack(IUnit target);

    /**
     * Receives a certain amount of damage.
     * @param damage the damage received.
     */
    void receiveDamage(double damage);

    /**
     * Receives a certain amount of heal.
     * @param power the power of the heal.
     */
    void receiveHeal(int power);
}
