package controller;

import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import handlers.LoseHandler;
import model.Factorys.Item.IEquipableItemFactory;
import model.Factorys.Unit.*;
import model.Tactician;
import model.items.IEquipableItem;
import model.map.Field;
import model.map.Location;
import model.units.Fighter;
import model.units.IUnit;
import model.units.Sorcerer;

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
    private Random random = new Random();
    private IEquipableItemFactory itemFactory;
    private AlpacaFactory alpacaFactory;
    private ArcherFactory archerFactory;
    private ClericFactory clericFactory;
    private FighterFactory fighterFactory;
    private HeroFactory heroFactory;
    private SorcererFactory sorcererFactory;
    private SwordMasterFactory swordMasterFactory;
    private PropertyChangeSupport loseNotification = new PropertyChangeSupport(this);


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
        LoseHandler loseHandler = new LoseHandler(this);
        //loseNotification.addPropertyChangeListener(loseHandler);
        for(int i = 0; i < numberOfPlayers; i++){
            allTacticians.add(new Tactician("Player "+i, map));
            tacticians.add(new Tactician("Player "+i, map));
            allTacticians.get(i).setGameController(this);
            tacticians.get(i).setGameController(this);
            tacticians.get(i).getUnitDeathNotification().addPropertyChangeListener(new LoseHandler(this));
        }

        turnOwner = tacticians.get(0);
        rounds=1;

    }

    /**
     * @return the list of all the tacticians currently participating in the game.
     */
    public List<Tactician> getTacticians() {
        return tacticians;
    }

    /**
     * @return the list of all the tacticians that participated in the game
     */
    public List<Tactician> getAllTacticians(){
        return allTacticians;
    }

    /**
     * @return the selected item
     */
    public IEquipableItem getSelectedItem(){
        return selectedItem;
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
     * @return the random seed of the controller for the shuffle
     */
    public Random getRandom(){
        return random;
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
                    Collections.shuffle(tacticians,random);
                }
                turnOwner = tacticians.get(0);
                rounds++;
                break;
            }
            else if(turnOwner == tacticians.get(i)){
                turnOwner = tacticians.get(i+1);
                break;
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
        for(Tactician tact: tacticians){
            if (tact.getName().equals(tactician)){
                tacticians.remove(tact);
                break;
            }
        }
    }

    /**
     * Starts the game.
     * @param maxTurns
     *  the maximum number of turns the game can last
     */
    public void initGame(final int maxTurns) {
        maxRounds = maxTurns;
        Collections.shuffle(tacticians);

    }

    /**
     * Starts a game without a limit of turns.
     */
    public void initEndlessGame() {
        maxRounds = -1;
        Collections.shuffle(tacticians);

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
     * Sets  a new Selected unit
     * @param unit the selected unit
     */
    public void setSelectedUnit(IUnit unit){
        selectedUnit = unit;
    }

    /**
     * Sets an specific map
     * @param field the map to be set
     */
    public void setMap(Field field){
        map = field;
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
        selectedUnit.equipItem(selectedUnit.getItems().get(index));
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

    public void moveSelectedUnit(Location targetLocation){
        selectedUnit.moveTo(targetLocation);
    }

    /**
     * Sets a seed for the randomness of the shuffle
     * @param seed the seed of the randomness
     */
    public void setRandom(Random seed){
        random = seed;
    }
}
