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

    public DarkFactory(Dark dark){
        this.dark = dark;
    }

    @Override
    public IEquipableItem createItem() {
        return new Dark(dark.getName(), dark.getPower(), dark.getMinRange(), dark.getMaxRange());
    }
}
