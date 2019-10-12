package model.items;


import model.units.IUnit;

/**
 * This class represents a Anima spell.
 *
 * Spells are strong against Light and melee items but weak against Dark and melee items.
 * @author Sebastian Valdivia Reyes
 * @since 1.0
 */
public class Anima extends MagicWeapon{

    /**
     * Creates a new Anima spell.
     *
     * @param name     the name of the spell
     * @param power    the damage of the spell (this could be the amount of damage or healing the item does)
     * @param minRange the minimum range of the spell
     * @param maxRange the maximum range of the spell
     */
    public Anima(String name, int power, int minRange, int maxRange) {
        super(name, power, minRange, maxRange);
    }

    @Override
    public void equipAnimaTo(IUnit unit) {
        this.equipTo(unit);
    }

    @Override
    public void attack(IEquipableItem target){
        double dist = this.getOwner().getLocation().distanceTo(target.getOwner().getLocation());
        if(!this.getOwner().isDead() && dist<=this.getMaxRange() && dist>=this.getMinRange()){
            target.receiveAnimaAttack(this);
        }
    }

    @Override
    public void receiveAnimaAttack(Anima anima){
        receiveAttack(anima);
    }

    @Override
    public  void receiveDarkAttack(Dark dark){
        receiveEffectiveDamage(dark);
    }

    @Override
    public  void receiveLightAttack(Light light){
        receiveNotEffectiveDamage(light);
    }

}
