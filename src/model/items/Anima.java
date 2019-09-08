package model.items;


import model.units.IUnit;

/**
 * This class represents a Anima spell.
 *
 * Spells are strong against Light and melee items but weak against Dark and melee items.
 * @author Sebastian Valdivia Reyes
 * @since 1.0
 */
public class Anima extends AbstractItem{

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
}
