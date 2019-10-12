package model.items;

import model.units.IUnit;

public interface IMagicWeapon extends IEquipableItem{
    /**
     * The unit equips a Anima Spell
     * @param unit that will be equipped with the Anima spell
     */
    void equipAnimaTo(IUnit unit);

    /**
     * The unit equips a Dark Spell
     * @param unit that will be equipped with the Dark spell
     */
    void equipDarkTo(IUnit unit);

    /**
     * The unit equips a Light Spell
     * @param unit that will be equipped with the Light spell
     */
    void equipLightTo(IUnit unit);
}
