package handlers;

import controller.GameController;
import model.units.IUnit;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Handler for the condition of lose if all units dies or the Hero dies
 *
 * @author Sebastian Valdivia Reyes
 * @version 2.0
 * @since 2.0
 */
public class LoseHandler implements PropertyChangeListener {
    private GameController gameController;

    /**
     * Creates a new handler  for the lose condition
     * @param gameController the controller to be notified if someone lose
     */
    public LoseHandler(GameController gameController){
        this.gameController = gameController;
    }


    /**
     * This method gets called when a bound property is changed.
     *
     * @param evt
     *     A PropertyChangeEvent object describing the event source
     *     and the property that has changed.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        gameController.removeTactician( ((IUnit)evt.getNewValue()).getTactician().getName());
    }
}
