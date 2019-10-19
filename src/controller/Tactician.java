package controller;

import model.items.IEquipableItem;
import model.map.Field;
import model.units.IUnit;

import java.util.ArrayList;
import java.util.List;

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
    private List<IEquipableItem> items = new ArrayList<>();
    private IUnit selectedUnit;

    /**
     * Creates a new Tactician
     * @param name of the tactician
     * @param map of the game
     * @param units the units that can handle
     * @param items the items that can handle
     */
    public Tactician (String name , Field map, List<IUnit> units, List<IEquipableItem> items){
        this.name = name;
        this.map = map;
        this.units = units;
        this.items = items;
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
     * @return a List with all the tactician Items
     */
    public List<IEquipableItem> getItems() {
        return items;
    }

    /**
     * @return the selected unit of the tactician
     */
    public IUnit getSelectedUnit() {
        return selectedUnit;
    }
}
