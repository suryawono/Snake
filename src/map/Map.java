/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package map;

import base.Coordinate;
import base.Unit;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author Quantum
 */
public class Map {

    //snake head will not show up at Coordinate for easy checking collision
    private ConcurrentHashMap<Unit, Coordinate> unitSet;

    public Map() {
        unitSet = new ConcurrentHashMap();
    }

    public void addUnit(Unit unit) {
        this.unitSet.put(unit, unit.getCoor());
    }

    public void addUnit(ArrayList<Unit> unit) {
        for (int i = 0; i < unit.size(); i++) {
            addUnit(unit.get(i));
        }
    }

    public Unit[] getUnitArray() {
        Object[] object = unitSet.keySet().toArray();
        Unit[] unit = new Unit[object.length];
        for (int i = 0; i < object.length; i++) {
            unit[i] = (Unit) object[i];
        }
        return unit;
    }

    public Set getUnitSet() {
        return unitSet.keySet();
    }

    public Coordinate getCoor(Unit unit) {
        return unitSet.get(unit);
    }

    public boolean isBlank(int x, int y) {
        Unit[] unit = getUnitArray();
        for (int i = 0; i < unit.length; i++) {
            if (unit[i].getCoor().containsXY(x, y)) {
                return false;
            }
        }
        return true;
    }

    public boolean isContainOnMap(int x, int y) {
        Unit[] unit = getUnitArray();
        for (int i = 0; i < unit.length; i++) {
            if (unit[i].coor.containsXY(x, y)) {
                return true;
            }
        }
        return false;
    }

    public void removeUnit(Unit unit) {
        unitSet.remove(unit);
    }

    public void removeUnit(Unit[] unit) {
        for (int i = 0; i < unit.length; i++) {
            removeUnit(unit[i]);
        }
    }

    public boolean isCoordinateValid(Coordinate coor) {
        int[] x = coor.getXPoint();
        int[] y = coor.getYPoint();
        for (int i = 0; i < x.length; i++) {
            if (this.isContainOnMap(x[i], y[i])) {
                return false;
            }
        }
        return true;
    }
}
