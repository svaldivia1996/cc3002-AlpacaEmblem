package model.Factorys.Unit;

import model.units.IUnit;
import model.units.Sorcerer;

/**
 * This class represents an Sorcerer factory that creates Sorcerers.
 *
 * @author Sebastian Valdivia Reyes
 * @since 2.0
 */
public class SorcererFactory implements IUnitFactory {
    private IUnit sorcerer;

    public SorcererFactory(Sorcerer sorcerer){
        this.sorcerer = sorcerer;
    }

    @Override
    public IUnit createUnit() {
        return new Sorcerer(sorcerer.getMaxHitPoints(),sorcerer.getMovement(),sorcerer.getLocation(),null);
    }
}
