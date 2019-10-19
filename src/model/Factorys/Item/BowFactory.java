package model.Factorys.Item;

import model.items.Bow;
import model.items.IEquipableItem;

/**
 * This class represents an Bow factory that creates Bows.
 *
 * @author Sebastian Valdivia Reyes
 * @since 2.0
 */
public class BowFactory implements IEquipableItemFactory {
    private IEquipableItem bow;

    public BowFactory(Bow bow){
        this.bow = bow;
    }


    @Override
    public IEquipableItem createItem() {
        return new Bow(bow.getName(), bow.getPower(), bow.getMinRange(), bow.getMaxRange());
    }
}
