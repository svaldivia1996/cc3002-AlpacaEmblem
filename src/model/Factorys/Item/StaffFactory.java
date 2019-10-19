package model.Factorys.Item;

import model.items.IEquipableItem;
import model.items.Staff;

/**
 * This class represents an Staff factory that creates Staff.
 *
 * @author Sebastian Valdivia Reyes
 * @since 2.0
 */
public class StaffFactory implements IEquipableItemFactory {
    private IEquipableItem staff;

    /**
     * creates a new Staff Factory.
     * @param staff the item used as mold.
     */
    public StaffFactory(Staff staff){
        this.staff = staff;
    }

    @Override
    public IEquipableItem createItem() {
        return new Staff(staff.getName(), staff.getPower(), staff.getMinRange(), staff.getMaxRange());
    }
}
