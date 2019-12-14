package model;

import model.items.IEquipableItem;
import model.map.Field;
import model.map.Location;
import model.units.IUnit;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Math.min;

/**
 * This class represents a tactician.
 * The responsibility of this entity will be to handle all user instructions
 * and delegate messages to model objects.
 * @author Sebastian Valdivia Reyes
 * @version 2.0
 * @since 2.0
 */
public class Tactician {

    private String name;
    private Field map;
    private List<IUnit> units = new ArrayList<>();
    private IUnit selectedUnit;

    /**
     * Creates a new Tactician
     * @param name of the tactician
     * @param map of the game
     * @param units the units that can handle
     */
    public Tactician (String name , Field map, IUnit... units){
        this.name = name;
        this.map = map;
        this.units.addAll(Arrays.asList(units));
    }

    //Getters

    /**
     * @return the name of the tactician
     */
    public String getName() {
        return name;
    }

    /**
     * @return the map of the game
     */
    public Field getMap() {
        return map;
    }

    /**
     * @return a List with all the tactician units
     */
    public List<IUnit> getUnits() {
        return units;
    }


    /**
     * @return the selected unit of the tactician
     */
    public IUnit getSelectedUnit() {
        return selectedUnit;
    }

    /**
     * @return the maximum amount of hit points of the selected unit
     */
    public int getMaxHitPointsSelectUnit(){
        return selectedUnit.getMaxHitPoints();
    }

    /**
     * @return the current amount of hit points of the selected unit
     */
    public int getCurrentHitPointsSelectedUnit(){
        return selectedUnit.getCurrentHitPoints();
    }

    /**
     * @return the items carried by the selected unit
     */
    public List<IEquipableItem> getItemsSelectedUnit(){
        return selectedUnit.getItems();
    }

    /**
     * @return the currently equipped item of the selected unit
     */
    public IEquipableItem getEquippedItemSelectedUnit(){
        return selectedUnit.getEquippedItem();
    }

    /**
     * @return the current location of the selected unit
     */
    public Location getLocationSelectedUnit(){
        return selectedUnit.getLocation();
    }

    /**
     * @return the number of cells the selected unit can move
     */
    public int getMovementSelectedUnit(){
        return selectedUnit.getMovement();
    }

    /**
     * @return the power of the item equipped by the selected unit
     */
    public int getPowerSelectedUnit(){
        return  selectedUnit.getEquippedItem().getPower();
    }

    //Actions

    /**
     * Equips an item from the inventory of the selected unit
     * @param item the item from the inventory
     */
    public void equipItemSelectedUnit(IEquipableItem item){
        selectedUnit.equipItem(item);
    }

    /**
     * Add an item to the inventory of the selected unit
     * @param item the item to be added
     */
    public void addItemSelectedUnit(IEquipableItem item){
        selectedUnit.addItem(item);
    }

    /**
     * Removes an item from the inventory of the selected unit
     * @param item the item to be removed
     */
    public void removeItemSelectedUnit(IEquipableItem item){
        selectedUnit.removeItem(item);
    }


    /**
     * Trade an item to another unit
     * @param item the item from the selected unit
     * @param other the other unit in the trade
     * @param otherItem the item in the other unit items list
     */
    public void tradeItemFromSelectedUnit(IEquipableItem item, IUnit other, IEquipableItem otherItem){
        selectedUnit.tradeItem(item, other, otherItem);
    }

    /**
     * Moves the selected unit to another location
     * If the other location is out of this unit's movement range or already moved in the actual turn, the unit doesn't move
     * @param targetLocation  the target location
     */
    public void moveSelectedUnit(Location targetLocation){
        if(targetLocation.getUnit()==null && !selectedUnit.getHasMoved()){
            selectedUnit.moveTo(targetLocation);
            selectedUnit.setHasMoved(true);
        }
    }

    /**
     * The actual unit attack the target unit, if the target is out of attack range nothing happens.
     * @param target unit to be attacked
     */
    public void selectedUnitAttack(IUnit target){
        selectedUnit.attack(target);
    }

    /**
     * The actual unit heal the target unit, if the target is out of heal range nothing happens.
     * @param target unit to be healed
     */
    public void selectedUnitHeal(IUnit target){
        selectedUnit.heal(target);
    }



}
