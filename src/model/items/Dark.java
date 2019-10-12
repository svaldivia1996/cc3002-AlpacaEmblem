package model.items;


import model.units.IUnit;

/**
 * This class represents a Dark spell.
 *
 * Spells are strong against Anima and melee items but weak against Light and melee items.
 * @author Sebastian Valdivia Reyes
 * @since 1.0
 */
public class Dark extends MagicWeapon {
    /**
     * Creates a new Dark spell.
     *
     * @param name     the name of the spell
     * @param power    the damage of the spell (this could be the amount of damage or healing the item does)
     * @param minRange the minimum range of the spell
     * @param maxRange the maximum range of the spell
     */
    public Dark(String name, int power, int minRange, int maxRange) {
        super(name, power, minRange, maxRange);
    }

    @Override
    public void equipDarkTo(IUnit unit) {
        this.equipTo(unit);
    }

    @Override
    public void attack(IEquipableItem target){
        double dist = this.getOwner().getLocation().distanceTo(target.getOwner().getLocation());
        if(!this.getOwner().isDead() && dist<=this.getMaxRange() && dist>=this.getMinRange()){
            target.receiveDarkAttack(this);
        }
    }

    @Override
    public void receiveDarkAttack(Dark dark){
        receiveAttack(dark);
    }

    @Override
    public  void receiveLightAttack(Light light){
        receiveEffectiveDamage(light);
    }

    @Override
    public void receiveAnimaAttack(Anima anima){
        receiveNotEffectiveDamage(anima);
    }
}
