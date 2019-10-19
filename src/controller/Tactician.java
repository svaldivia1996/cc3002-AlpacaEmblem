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
    private Field map;
    private List<IUnit> units = new ArrayList<>();
    private List<IEquipableItem> items = new ArrayList<>();
    private IUnit selectedUnit;


}
