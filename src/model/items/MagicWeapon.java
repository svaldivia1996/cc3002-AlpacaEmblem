package model.items;


import model.units.IUnit;

/**
 * Abstract class that defines some common information and behaviour between all Magic Weapons.
 * @author Sebastian Valdivia Reyes
 * @since 1.1
 */
public abstract class MagicWeapon extends AbstractItem implements IMagicWeapon {
    private String name;
    private int power;
    protected int maxRange;
    protected int minRange;
    private IUnit owner;

    /**
     * Constructor for a Magic weapon
     * @param name of the weapon
     * @param power the amount of damage of the weapon
     * @param minRange the minimum range of the weapon
     * @param maxRange the maximum range of the weapon
     */
    public MagicWeapon(final String name, final int power, final int minRange, final int maxRange){
        super(name, power, minRange, maxRange);
    }

    @Override
    public void equipAnimaTo(final IUnit unit){}

    @Override
    public void equipDarkTo(final IUnit unit){}

    @Override
    public void equipLightTo(final IUnit unit){}

    @Override
    public void receiveDarkAttack(Dark dark){
        receiveEffectiveDamage(dark);
    }

    @Override
    public void receiveLightAttack(Light light){
        receiveNotEffectiveDamage(light);
    }

    @Override
    public void receiveAnimaAttack(Anima anima){
        receiveNotEffectiveDamage(anima);
    }

    @Override
    public void receiveAxeAttack(Axe axe){
        receiveEffectiveDamage(axe);
    }

    @Override
    public void receiveSpearAttack(Spear spear){
        receiveEffectiveDamage(spear);
    }

    @Override
    public void receiveSwordAttack(Sword sword){
        receiveEffectiveDamage(sword);
    }


}
