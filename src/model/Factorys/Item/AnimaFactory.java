package model.Factorys.Item;

import model.items.Anima;
import model.items.IEquipableItem;

/**
 * This class represents an Anima factory that creates Anima spells.
 *
 * @author Sebastian Valdivia Reyes
 * @since 2.0
 */
public class AnimaFactory implements IEquipableItemFactory {
    private Anima anima;

    public AnimaFactory(Anima anima){
        this.anima = anima;
    }


    @Override
    public IEquipableItem createItem() {
        return new Anima(anima.getName(), anima.getPower(), anima.getMinRange(), anima.getMaxRange());
    }
}
