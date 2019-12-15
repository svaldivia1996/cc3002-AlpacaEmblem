package model.units;

import static java.lang.Math.min;

import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.Tactician;
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

    private Tactician tactician;
    private final int maxHitPoints;
    private int currentHitPoints;
    private int movement;
    private Location location;
    protected final List<IEquipableItem> items = new ArrayList<>();
    protected IEquipableItem equippedItem;
    private boolean hasMoved;




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
   *
   */
  protected AbstractUnit(final int hitPoints, final int movement,
      final Location location, final int maxItems, final IEquipableItem... items) {
    this.maxHitPoints = hitPoints;
    this.currentHitPoints = hitPoints;
    this.movement = movement;
    this.location = location;
    this.items.addAll(Arrays.asList(items).subList(0, min(maxItems, items.length)));
    this.hasMoved = false;

  }

  @Override
  public boolean equals(Object obj){
      return maxHitPoints == ((IUnit)obj).getMaxHitPoints() && movement == ((IUnit) obj).getMovement();
  }

  @Override
  public boolean isHero(){
      return false;
  }

  @Override
  public Tactician getTactician(){
      return this.tactician;
  }

  @Override
  public void setTactician(Tactician tactician){
      this.tactician = tactician;
  }

  @Override
  public  boolean getHasMoved(){
      return hasMoved;
  }

  @Override
  public void setHasMoved(boolean hasMoved){
      this.hasMoved = hasMoved;
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
  public void addItem(IEquipableItem item){
    if(this.items.size()<= 3) {
      this.items.add(item);
    }
  }

  @Override
  public void removeItem(IEquipableItem item){
      if(this.equippedItem == item){
          equippedItem = null;
      }
      this.items.remove(item);
  }

  @Override
  public void tradeItem(IEquipableItem item,IUnit other, IEquipableItem otherItem){
      double dist =this.getLocation().distanceTo(other.getLocation());
      if(dist ==1 && this.getItems().size() < 3 && item == null && other.getItems().contains(otherItem)){
          this.addItem(otherItem);
          other.removeItem(otherItem);
      }
      else if(dist ==1 && this.getItems().contains(item) && other.getItems().size() < 3 && otherItem == null){
          other.addItem(item);
          this.removeItem(item);
      }
      else if(dist ==1 && this.getItems().contains(item) && other.getItems().contains(otherItem)){
          IEquipableItem aux = item;
          this.removeItem(item);
          this.addItem(otherItem);
          other.removeItem(otherItem);
          other.addItem(aux);
      }

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
    if (getLocation().distanceTo(targetLocation) <= getMovement() && targetLocation.getUnit() == null) {
      setLocation(targetLocation);
      targetLocation.setUnit(this);
    }
  }

  @Override
  public void attack(IUnit other){
    double dist = this.getLocation().distanceTo(other.getLocation());
    if(!this.isDead() && other.getEquippedItem() != null && dist<=this.getEquippedItem().getMaxRange() && dist>=this.getEquippedItem().getMinRange()){
      this.getEquippedItem().attack(other.getEquippedItem());
      counterAttack(other);
    }
    else if (dist<=this.getEquippedItem().getMaxRange() && dist>=this.getEquippedItem().getMinRange()){
      other.receiveDamage(this.getEquippedItem().getPower());
    }
  }

  @Override
  public void heal(IUnit other){
    double dist = this.getLocation().distanceTo(other.getLocation());
    if(!this.isDead() && other.getEquippedItem() != null && dist<=this.getEquippedItem().getMaxRange() && dist>=this.getEquippedItem().getMinRange()){
      this.getEquippedItem().heal(other.getEquippedItem());
    }
    else if (dist<=this.getEquippedItem().getMaxRange() && dist>=this.getEquippedItem().getMinRange()){
      other.receiveHeal(this.getEquippedItem().getPower());
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
  public void receiveDamage(int damage) {
    this.currentHitPoints -= damage;
    this.currentHitPoints =  Math.max(0 , this.currentHitPoints);
  }

  @Override
  public void receiveHeal(int power) {
    this.currentHitPoints = Math.min(this.maxHitPoints,this.currentHitPoints+power);
  }


}
