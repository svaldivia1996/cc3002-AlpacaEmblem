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

    /**
     * Receives an attack.
     * @param item the item used to attack.
     */
    void receiveAttack(IEquipableItem item);

    /**
     * Receives a Effective damage attack.
     * @param item the item used to attack.
     */
    void receiveEffectiveDamage(IEquipableItem item);


    /**
     * receives a Not Effective damage attack.
     * @param item the item used to attack.
     */
    void receiveNotEffectiveDamage(IEquipableItem item);



}
