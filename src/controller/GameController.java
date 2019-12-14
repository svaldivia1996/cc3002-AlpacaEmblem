package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.Factorys.Item.IEquipableItemFactory;
import model.Factorys.Unit.IUnitFactory;
import model.Tactician;
import model.items.IEquipableItem;
import model.map.Field;
import model.units.IUnit;

/**
 * Controller of the game.
 * The controller manages all the input received from de game's GUI.
 *
 * @author Sebastian Valdivia Reyes
 * @author Ignacio Slater Muñoz
 * @version 2.0
 * @since 2.0
 */
public class GameController {
    private List<Tactician> allTacticians = new ArrayList<>();
    private List<Tactician> tacticians= new ArrayList<>();
    private Field map;
    private Tactician  turnOwner;
    private IUnit selectedUnit;
    private IEquipableItem selectedItem;
    private int rounds, maxRounds;
    private IEquipableItemFactory itemFactory;
    private IUnitFactory unitFactory;


    /**
     * Creates the controller for a new game.
     *
     * @param numberOfPlayers
     *     the number of players for this game
     * @param mapSize
     *     the dimensions of the map, for simplicity, all maps are squares
     */
    public GameController(int numberOfPlayers, int mapSize) {
        map = new Field();
        map.newRandomMap(mapSize);
        for(int i = 0; i < numberOfPlayers; i++){
            allTacticians.add(new Tactician("Player "+i, map));
            tacticians.add(new Tactician("Player "+i, map));
        }

    }

    /**
     * @return the list of all the tacticians participating in the game.
     */
    public List<Tactician> getTacticians() {
        return allTacticians;
    }

    /**
     * @return the map of the current game
     */
    public Field getGameMap() {
        return map;
    }

    /**
     * @return the tactician that's currently playing
     */
    public Tactician getTurnOwner() {
        return turnOwner;
    }

    /**
     * @return the number of rounds since the start of the game.
     */
    public int getRoundNumber() {
        return rounds;
    }

    /**
     * @return the maximum number of rounds a match can last
     */
    public int getMaxRounds() {
        return maxRounds;
    }

    /**
     * Finishes the current player's turn.
     */
    public void endTurn() {

        //ending the turn allows to move the units again in the next turn
        for(IUnit unit : turnOwner.getUnits()){
            unit.setHasMoved(false);
        }


        for(int i = 0; i < tacticians.size(); i++ ){
            //if the turn owner is the last one to play in the round, it cannot be the first to play in the next round
            if(turnOwner == tacticians.get(i) && i == tacticians.size()-1){
                Collections.shuffle(tacticians);
                while(turnOwner == tacticians.get(0)){
                    Collections.shuffle(tacticians);
                }
                turnOwner = tacticians.get(0);
                rounds++;
            }
            else if(turnOwner == tacticians.get(i)){
                turnOwner = tacticians.get(i+1);
            }
        }
    }

    /**
     * Removes a tactician and all of it's units from the game.
     *
     * @param tactician
     *     the player to be removed
     */
    public void removeTactician(String tactician) {
        tacticians.remove(tactician);
    }

    /**
     * Starts the game.
     * @param maxTurns
     *  the maximum number of turns the game can last
     */
    public void initGame(final int maxTurns) {
        maxRounds = maxTurns;
    }

    /**
     * Starts a game without a limit of turns.
     */
    public void initEndlessGame() {
        maxRounds = -1;
    }

    /**
     * @return the winner of this game, if the match ends in a draw returns a list of all the winners
     */
    public List<String> getWinners() {
        List<String> winners = new ArrayList<>();
        for (Tactician tactician: tacticians) {
            winners.add(tactician.getName());
        }
        return winners;
    }

    /**
     * @return the current player's selected unit
     */
    public IUnit getSelectedUnit() {
        return getTurnOwner().getSelectedUnit();
    }

    /**
     * Selects a unit in the game map
     *
     * @param x
     *     horizontal position of the unit
     * @param y
     *     vertical position of the unit
     */
    public void selectUnitIn(int x, int y) {
        selectedUnit = map.getCell(x,y).getUnit();
    }

    /**
     * @return the inventory of the currently selected unit.
     */
    public List<IEquipableItem> getItems() {
        return turnOwner.getSelectedUnit().getItems();
    }

    /**
     * Equips an item from the inventory to the currently selected unit.
     *
     * @param index
     *     the location of the item in the inventory.
     */
    public void equipItem(int index) {
        selectedUnit.equipItem(selectedUnit.getItems().remove(index));
    }

    /**
     * Uses the equipped item on a target
     *
     * @param x
     *     horizontal position of the target
     * @param y
     *     vertical position of the target
     */
    public void useItemOn(int x, int y) {
        selectedUnit.attack(map.getCell(x,y).getUnit());
    }

    /**
     * Selects an item from the selected unit's inventory.
     *
     * @param index
     *     the location of the item in the inventory.
     */
    public void selectItem(int index) {
        selectedItem = selectedUnit.getItems().get(index);
    }

    /**
     * Gives the selected item to a target unit.
     *
     * @param x
     *     horizontal position of the target
     * @param y
     *     vertical position of the target
     */
    public void giveItemTo(int x, int y) {
        selectedUnit.tradeItem(selectedItem,map.getCell(x,y).getUnit(),null);
    }
}
