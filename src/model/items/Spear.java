package model.items;

import model.units.IUnit;

/**
 * This class represents a <i>spear</i>.
 * <p>
 * Spears are strong against swords and weak against axes
 *
 * @author Ignacio Slater Muñoz
 * @author Sebastian Valdivia Reyes
 * @since 1.0
 */
public class Spear extends AbstractItem {

  /**
   * Creates a new Axe item
   *
   * @param name
   *     the name of the Axe
   * @param power
   *     the damage of the axe
   * @param minRange
   *     the minimum range of the axe
   * @param maxRange
   *     the maximum range of the axe
   */
  public Spear(final String name, final int power, final int minRange, final int maxRange) {
    super(name, power, minRange, maxRange);
  }

  @Override
  public void attack(IEquipableItem target){
    double dist = this.getOwner().getLocation().distanceTo(target.getOwner().getLocation());
    if(!this.getOwner().isDead() && dist<=this.getMaxRange() && dist>=this.getMinRange()){
      target.receiveSpearAttack(this);
    }
  }

  @Override
  public void equipSpearTo(IUnit unit){
    this.equipTo(unit);
  }

  @Override
  public void receiveAxeAttack(Axe axe){
    receiveEffectiveDamage(axe);
  }

  @Override
  public void receiveSwordAttack(Sword sword){
    receiveNotEffectiveDamage(sword);
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
