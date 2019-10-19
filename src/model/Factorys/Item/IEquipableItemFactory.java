package model.Factorys.Item;

import model.items.IEquipableItem;

/**
 * This interface represents the Item factory that creates new items.
 * @author Sebastian Valdivia Reyes
 * @since 2.0
 */
public interface IEquipableItemFactory {

    /**
     * creates a new Item.
     * @return the Item created.
     */
    public IEquipableItem createItem();

}
