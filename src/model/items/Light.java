package model.items;


import model.units.IUnit;

/**
 * This class represents a Light spell.
 *
 * Spells are strong against Dark and melee items but weak against Anima and melee items.
 * @author Sebastian Valdivia Reyes
 * @since 1.0
 */
public class Light extends MagicWeapon {
    /**
     * Creates a new Light spell.
     *
     * @param name     the name of the spell
     * @param power    the damage of the spell (this could be the amount of damage or healing the item does)
     * @param minRange the minimum range of the spell
     * @param maxRange the maximum range of the spell
     */
    public Light(String name, int power, int minRange, int maxRange) {
        super(name, power, minRange, maxRange);
    }

    @Override
    public void attack(IEquipableItem target){
        double dist = this.getOwner().getLocation().distanceTo(target.getOwner().getLocation());
        if(!this.getOwner().isDead() && dist<=this.getMaxRange() && dist>=this.getMinRange()){
            target.receiveLightAttack(this);
        }
    }
    @Override
    public void equipLightTo(IUnit unit) {
        this.equipTo(unit);
    }

    @Override
    public void receiveLightAttack(Light light) {
        receiveAttack(light);
    }

    @Override
    public void receiveAnimaAttack(Anima anima){
        receiveEffectiveDamage(anima);
    }

    @Override
    public void receiveDarkAttack(Dark dark){
        receiveNotEffectiveDamage(dark);
    }

}
