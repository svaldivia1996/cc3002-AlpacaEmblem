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
    if(!this.isDead()){
      other.receiveAttack(getEquippedItem());
    }
  }

  @Override
  public void receiveAxeAttack(Axe axe) {
    receiveAttack(axe);
  }

  @Override
  public void receiveSwordAttack(Sword sword) {
    receiveAttack(sword);
  }

  @Override
  public void receiveSpearAttack(Spear spear) {
    receiveAttack(spear);
  }

  @Override
  public void receiveStaffAttack(Staff staff) {
    receiveAttack(staff);
  }

  @Override
  public void receiveBowAttack(Bow bow) {
    receiveAttack(bow);
  }

  @Override
  public void receiveAnimaAttack(Anima anima) {
    receiveAttack(anima);
  }

  @Override
  public void receiveDarkAttack(Dark dark) {
    receiveAttack(dark);
  }

  @Override
  public void receiveLightAttack(Light light) {
    receiveAttack(light);
  }

  @Override
  public void receiveAttack(IEquipableItem item) {
    if(item != null) {
      this.currentHitPoints -= item.getPower();
    }
  }

  @Override
  public void receiveEffectiveDamage(IEquipableItem item){
    this.currentHitPoints -= item.getPower()*1.5;
  }

  @Override
  public void receiveNotEffectiveDamage(IEquipableItem item){
    this.currentHitPoints -= Math.max(0,item.getPower()-20);
  }





}
