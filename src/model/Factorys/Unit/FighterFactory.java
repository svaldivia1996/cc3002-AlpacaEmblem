package model.Factorys.Unit;

import model.units.Fighter;
import model.units.IUnit;

/**
 * This class represents an Fighter factory that creates Fighters.
 *
 * @author Sebastian Valdivia Reyes
 * @since 2.0
 */
public class FighterFactory implements IUnitFactory {
    private IUnit fighter;

    /**
     * Creates a new Fighter Factory.
     * @param fighter the unit used as mold.
     */
    public FighterFactory(Fighter fighter){
        this.fighter = fighter;
    }

    @Override
    public IUnit createUnit() {
        return new Fighter(fighter.getMaxHitPoints(), fighter.getMovement(), fighter.getLocation(),null);
    }
}
