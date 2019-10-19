package model.Factorys.Unit;

import model.units.Cleric;
import model.units.IUnit;

/**
 * This class represents an Cleric factory that creates Clerics.
 *
 * @author Sebastian Valdivia Reyes
 * @since 2.0
 */
public class ClericFactory implements IUnitFactory {
    private IUnit cleric;

    /**
     * Creates a new Cleric Factory.
     * @param cleric the unit used as mold.
     */
    public ClericFactory(Cleric cleric){
        this.cleric = cleric;
    }


    @Override
    public IUnit createUnit() {
        return new Cleric(cleric.getMaxHitPoints(), cleric.getMovement(), cleric.getLocation(),null);
    }
}
