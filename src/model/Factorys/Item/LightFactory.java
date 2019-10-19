package model.Factorys.Item;

import model.items.IEquipableItem;
import model.items.Light;

/**
 * This class represents an Light factory that creates Light spells.
 *
 * @author Sebastian Valdivia Reyes
 * @since 2.0
 */
public class LightFactory implements IEquipableItemFactory{
    private IEquipableItem light;

    public LightFactory(Light light){
        this.light = light;
    }

    @Override
    public IEquipableItem createItem() {
        return new Light(light.getName(), light.getPower(), light.getMinRange(), light.getMaxRange());
    }
}
