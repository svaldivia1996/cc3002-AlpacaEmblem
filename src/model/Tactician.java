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
}
