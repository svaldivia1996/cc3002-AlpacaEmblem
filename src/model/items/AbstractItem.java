package model.items;

import model.units.IUnit;

/**
 * Abstract class that defines some common information and behaviour between all items.
 *
 * @author Ignacio Slater Muñoz
 * @author Sebastian Valdivia Reyes
 * @since 1.0
 */
public abstract class AbstractItem implements IEquipableItem {

  private final String name;
  private final int power;
  protected int maxRange;
  protected int minRange;
  private IUnit owner;

  /**
   * Constructor for a default item without any special behaviour.
   *
   * @param name
   *     the name of the item
   * @param power
   *     the power of the item (this could be the amount of damage or healing the item does)
   * @param minRange
   *     the minimum range of the item
   * @param maxRange
   *     the maximum range of the item
   */
  public AbstractItem(final String name, final int power, final int minRange, final int maxRange) {
    this.name = name;
    this.power = power;
    this.minRange = Math.max(minRange, 1);
    this.maxRange = Math.max(maxRange, this.minRange);
  }

  @Override
  public void equipTo(final IUnit unit) {
    unit.setEquippedItem(this);
    owner = unit;
  }

  @Override
  public IUnit getOwner() {
    return owner;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public int getPower() {
    return power;
  }

  @Override
  public int getMinRange() {
    return minRange;
  }

  @Override
  public int getMaxRange() {
    return maxRange;
  }

  @Override
  public void equipBowTo(final IUnit unit){}

  @Override
  public void equipAxeTo(final IUnit unit){}

  @Override
  public void equipSpearTo(final IUnit unit){}

  @Override
  public void equipStaffTo(final IUnit unit){}

  @Override
  public void equipSwordTo(final IUnit unit){}

  @Override
  public void equipAnimaTo(final IUnit unit){}

  @Override
  public void equipDarkTo(final IUnit unit){}

  @Override
  public void equipLightTo(final IUnit unit){}

  @Override
  public void attack(IEquipableItem target){
    double dist = this.owner.getLocation().distanceTo(target.getOwner().getLocation());
    if(!this.owner.isDead() && dist<=this.getMaxRange() && dist>=this.getMinRange() && target != null){
      target.receiveAttack(this);
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
      this.owner.receiveDamage(item.getPower());
    }
  }

  @Override
  public void receiveEffectiveDamage(IEquipableItem item){
    this.owner.receiveDamage(item.getPower()*1.5);
  }

  @Override
  public void receiveNotEffectiveDamage(IEquipableItem item){
    this.owner.receiveDamage(Math.max(0,item.getPower()-20));
  }



}
