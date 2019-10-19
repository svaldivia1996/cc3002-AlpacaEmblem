package model.Factorys;

import model.units.IUnit;
import model.units.SwordMaster;


/**
 * This class represents an SwordMaster factory that creates Swordmasters.
 *
 * @author Sebastian Valdivia Reyes
 * @since 2.0
 */
public class SwordMasterFactory implements IUnitFactory {
    private IUnit swordMaster;

    public SwordMasterFactory(SwordMaster swordMaster){
        this.swordMaster = swordMaster;
    }

    @Override
    public IUnit createUnit() {
        return new SwordMaster(swordMaster.getMaxHitPoints(), swordMaster.getMovement(), swordMaster.getLocation(),null);
    }
}
