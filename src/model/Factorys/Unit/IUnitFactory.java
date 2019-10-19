package model.Factorys.Unit;

import model.units.IUnit;

/**
 * This interface represents the unit factory that creates new units.
 * @author Sebastian Valdivia Reyes
 * @since 2.0
 */
public interface IUnitFactory {

    /**
     * Creates a new Unit
     * @return the unit created.
     */
    public IUnit createUnit();

}
