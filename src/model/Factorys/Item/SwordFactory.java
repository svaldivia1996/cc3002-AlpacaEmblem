package model.Factorys.Item;

import model.Factorys.Unit.SwordMasterFactory;
import model.items.IEquipableItem;
import model.items.Sword;

public class SwordFactory implements IEquipableItemFactory {
    private IEquipableItem sword;

    public SwordFactory(Sword sword){
        this.sword = sword;
    }

    @Override
    public IEquipableItem createItem() {
        return new Sword(sword.getName(), sword.getPower(), sword.getMinRange(), sword.getMaxRange());
    }
}
