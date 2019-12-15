package model.Factorys.Unit;

import model.units.Alpaca;
import model.units.IUnit;

/**
 * This class represents an Alpaca factory that creates Alpacas.
 *
 * @author Sebastian Valdivia Reyes
 * @since 2.0
 */
public class AlpacaFactory implements IUnitFactory {
    private IUnit alpaca;

    /**
     * Creates a new Alpaca Factory.
     * @param alpaca the unit used as mold.
     */
    public AlpacaFactory(Alpaca alpaca){
        this.alpaca = alpaca;
    }


    @Override
    public IUnit createUnit() {
        return new Alpaca(alpaca.getMaxHitPoints(),alpaca.getMovement(),alpaca.getLocation());
    }
}
