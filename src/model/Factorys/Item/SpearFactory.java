package model.Factorys.Item;

import model.items.IEquipableItem;
import model.items.Spear;
import model.units.IUnit;

/**
 * This class represents an Spear factory that creates Spears.
 *
 * @author Sebastian Valdivia Reyes
 * @since 2.0
 */
public class SpearFactory implements IEquipableItemFactory {
    private IEquipableItem spear;

    public SpearFactory(Spear spear){
        this.spear = spear;
    }

    @Override
    public IEquipableItem createItem() {
        return new Spear(spear.getName(), spear.getPower(), spear.getMinRange(), spear.getMaxRange());
    }
}
