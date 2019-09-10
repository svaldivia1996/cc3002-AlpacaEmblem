package model.units;

import static java.lang.Math.min;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.items.*;
import model.map.Location;

/**
 * This class represents an abstract unit.
 * <p>
 * An abstract unit is a unit that cannot be used in the
 * game, but that contains the implementation of some of the methods that are common for most
 * units.
 *
 * @author Ignacio Slater Muñoz
 * @author Sebastian Valdivia Reyes
 * @since 1.0
 */
public abstract class AbstractUnit implements IUnit {

    private final int maxHitPoints;
    private int currentHitPoints;
    private int movement;
    private Location location;
    protected final List<IEquipableItem> items = new ArrayList<>();
    protected IEquipableItem equippedItem;



  /**
   * Creates a new Unit.
   *
   *
   * @param hitPoints
   *     the maximum amount of damage a unit can sustain
   * @param movement
   *     the number of panels a unit can move
   * @param location
   *     the current position of this unit on the map
   * @param maxItems
   *     maximum amount of items this unit can carry
   * @param items
   *     the items carried by this unit
   */
  protected AbstractUnit(final int hitPoints, final int movement,
      final Location location, final int maxItems, final IEquipableItem... items) {
    this.maxHitPoints = hitPoints;
    this.currentHitPoints = hitPoints;
    this.movement = movement;
    this.location = location;
    this.items.addAll(Arrays.asList(items).subList(0, min(maxItems, items.length)));
  }

  @Override
  public boolean isDead(){
    return getCurrentHitPoints() <= 0;
  }

  @Override
  public int getMaxHitPoints() {
    return maxHitPoints;
  }

  @Override
  public int getCurrentHitPoints() {
    return currentHitPoints;
  }

  @Override
  public List<IEquipableItem> getItems() {
    return List.copyOf(items);
  }

  @Override
  public IEquipableItem getEquippedItem() {
    return equippedItem;
  }

  @Override
  public void setEquippedItem(final IEquipableItem item) {
    this.equippedItem = item;
  }

  @Override
  public Location getLocation() {
    return location;
  }

  @Override
  public void setLocation(final Location location) {
    this.location = location;
  }

  @Override
  public int getMovement() {
    return movement;
  }

  @Override
  public void moveTo(final Location targetLocation) {
    if (getLocation().distanceTo(targetLocation) <= getMovement()
        && targetLocation.getUnit() == null) {
      setLocation(targetLocation);
    }
  }

  @Override
  public void attack(IUnit other){
    double dist = this.getLocation().distanceTo(other.getLocation());
    if(!this.isDead() && other.getEquippedItem() != null && dist<=this.getEquippedItem().getMaxRange() && dist>=this.getEquippedItem().getMinRange()){
      this.getEquippedItem().attack(other.getEquippedItem());
      //other.getEquippedItem().receiveAttack(getEquippedItem());
      counterAttack(other);
    }
    else if (dist<=this.getEquippedItem().getMaxRange() && dist>=this.getEquippedItem().getMinRange()){
      other.receiveDamage(this.getEquippedItem().getPower());
    }
  }

  @Override
  public void counterAttack(IUnit other){
    double dist = this.getLocation().distanceTo(other.getLocation());
    if(!other.isDead() &&  dist<=other.getEquippedItem().getMaxRange() && dist>=other.getEquippedItem().getMinRange()){
      other.getEquippedItem().attack(this.getEquippedItem());
    }
  }

  @Override
  public void receiveDamage(double damage) {
    this.currentHitPoints -= damage;
  }


}
