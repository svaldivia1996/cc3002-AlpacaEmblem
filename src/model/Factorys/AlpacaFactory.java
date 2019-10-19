package model.Factorys;

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

    public AlpacaFactory(Alpaca alpaca){
        this.alpaca = alpaca;
    }


    @Override
    public IUnit createUnit() {
        return new Alpaca(alpaca.getMaxHitPoints(),alpaca.getMovement(),alpaca.getLocation(),null);
    }
}
