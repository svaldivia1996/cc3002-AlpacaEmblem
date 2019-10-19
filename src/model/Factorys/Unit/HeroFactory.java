package model.Factorys.Unit;

import model.units.Hero;
import model.units.IUnit;

/**
 * This class represents an Hero factory that creates Heroes.
 *
 * @author Sebastian Valdivia Reyes
 * @since 2.0
 */
public class HeroFactory implements IUnitFactory{
    private IUnit hero;

    /**
     * Creates a new Hero Factory.
     * @param Hero the unit used as mold.
     */
    public HeroFactory(Hero hero){
        this.hero = hero;
    }

    @Override
    public IUnit createUnit() {
        return new Hero(hero.getMaxHitPoints(), hero.getMovement(), hero.getLocation(), null);
    }
}
