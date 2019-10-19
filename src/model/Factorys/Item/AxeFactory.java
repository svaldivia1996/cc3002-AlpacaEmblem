package model.Factorys.Item;

import model.items.Axe;
import model.items.IEquipableItem;


/**
 * This class represents an Axe factory that creates Axes.
 *
 * @author Sebastian Valdivia Reyes
 * @since 2.0
 */
public class AxeFactory implements IEquipableItemFactory{
    private IEquipableItem axe;

    /**
     * creates a new Axe Factory.
     * @param axe the item used as mold.
     */
    public AxeFactory(Axe axe){
        this.axe = axe;
    }

    @Override
    public IEquipableItem createItem() {
        return new Axe(axe.getName(), axe.getPower(), axe.getMinRange(), axe.getMaxRange());
    }
}
