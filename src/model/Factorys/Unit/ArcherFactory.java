package model.Factorys.Unit;

import model.units.Archer;
import model.units.IUnit;

/**
 * This class represents an Archer factory that creates Archers
 *
 * @author Sebastian Valdivia Reyes
 * @since 2.0
 */
public class ArcherFactory implements IUnitFactory {
    private IUnit archer;

    /**
     * Creates a new Archer Factory.
     * @param archer the unit used as mold.
     */
    public ArcherFactory(Archer archer){
        this.archer = archer;
    }

    @Override
    public IUnit createUnit() {
        return new Archer(archer.getMaxHitPoints(), archer.getMovement(), archer.getLocation());
    }
}
