package model.items;

import model.units.IUnit;

/**
 * This class represents an Axe.
 * <p>
 * Axes are strong against spears but weak agains swords.
 *
 * @author Ignacio Slater Muñoz
 * @author Sebastian Valdivia Reyes
 * @since 1.0
 */
public class Axe extends AbstractItem {

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
    public Axe(final String name, final int power, final int minRange, final int maxRange) {
        super(name, power, minRange, maxRange);
    }

    @Override
    public void equipAxeTo(IUnit unit){
        this.equipTo(unit);
    }

    @Override
    public void receiveSwordAttack(Sword sword){
        receiveEffectiveDamage(sword);
    }

    @Override
    public void receiveSpearAttack(Spear spear){
        receiveNotEffectiveDamage(spear);
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
