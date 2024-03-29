package model.items;

import model.units.IUnit;

/**
 * This class represents a sword type item.
 * <p>
 * Swords are strong against axes and weak against spears.
 *
 * @author Ignacio Slater Muñoz
 * @author Sebastian Valdivia Reyes
 * @since 1.0
 */
public class Sword extends AbstractItem {

  /**
   * Creates a new Sword.
   *
   * @param name
   *     the name that identifies the weapon
   * @param power
   *     the base damage pf the weapon
   * @param minRange
   *     the minimum range of the weapon
   * @param maxRange
   *     the maximum range of the weapon
   */
  public Sword(final String name, final int power, final int minRange, final int maxRange) {
    super(name, power, minRange, maxRange);
  }

  @Override
  public void attack(IEquipableItem target){
    double dist = this.getOwner().getLocation().distanceTo(target.getOwner().getLocation());
    if(!this.getOwner().isDead() && dist<=this.getMaxRange() && dist>=this.getMinRange()){
      target.receiveSwordAttack(this);
    }
  }

  @Override
  public void equipSwordTo(IUnit unit){
    this.equipTo(unit);
  }

  @Override
  public void receiveSpearAttack(Spear spear){
    receiveEffectiveDamage(spear);
  }

  @Override
  public void receiveAxeAttack(Axe axe){
    receiveNotEffectiveDamage(axe);
  }

  @Override
  public void receiveAnimaAttack(Anima anima) {
    receiveEffectiveDamage(anima);
  }

  @Override
  public void receiveDarkAttack(Dark dark) {
    receiveEffectiveDamage(dark);
  }

  @Override
  public void receiveLightAttack(Light light) {
    receiveEffectiveDamage(light);
  }
}
