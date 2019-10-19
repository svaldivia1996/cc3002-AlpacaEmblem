package model.Factorys.Item;


import model.items.Dark;
import model.items.IEquipableItem;

/**
 * This class represents an Dark factory that creates Dark spells.
 *
 * @author Sebastian Valdivia Reyes
 * @since 2.0
 */
public class DarkFactory implements IEquipableItemFactory {
    private IEquipableItem dark;

    /**
     * creates a new Dark Factory.
     * @param dark the item used as mold.
     */
    public DarkFactory(Dark dark){
        this.dark = dark;
    }

    @Override
    public IEquipableItem createItem() {
        return new Dark(dark.getName(), dark.getPower(), dark.getMinRange(), dark.getMaxRange());
    }
}
