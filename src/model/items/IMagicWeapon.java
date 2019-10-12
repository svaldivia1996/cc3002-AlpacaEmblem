package model.items;

import model.units.IUnit;

/**
 * This Interface respresents the Magic Weapons that the sorcerers can use.
 *
 * The signature for all the common methods of the weapons are defined here. Every weapon have a
 * base damage and is strong or weak against other type of weapons.
 * @author Sebastian Valdivia Reyes
 * @since 1.1
 */
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
