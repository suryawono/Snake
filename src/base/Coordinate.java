/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package base;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import snake.Snake;

/**
 *
 * @author Quantum
 */
public class Coordinate {

    private ConcurrentHashMap<Integer, ArrayList<Integer>> xy;

    public Coordinate() {
        xy = new ConcurrentHashMap();
    }

    public Coordinate(int x, int y) {
        xy = new ConcurrentHashMap();
        this.putCoor(x, y);
    }

    public int[] getXPoint() {
        int[] xPoint = new int[totalPoint()];
        int counter = 0;
        Object[] object = xy.keySet().toArray();
        for (int i = 0; i < object.length; i++) {
            Integer tempX = (Integer) object[i];
            if (xy.get(tempX).size() == 1) {
                xPoint[counter] = tempX;
                counter++;
            } else {
                for (int j = 0; j < xy.get(tempX).size(); j++) {
                    xPoint[counter++] = tempX;
                }
            }
        }
        return xPoint;
    }

    public int[] getYPoint() {
        int[] yPoint = new int[totalPoint()];
        int counter = 0;
        Object[] object = xy.keySet().toArray();
        for (int i = 0; i < object.length; i++) {
            Integer tempX = (Integer) object[i];
            for (int j = 0; j < xy.get(tempX).size(); j++) {
                yPoint[counter++] = xy.get(tempX).get(j);
            }
        }
        return yPoint;
    }

    private void putCoor(int x, int y) {
        if (xy.containsKey(x)) {
        } else {
            xy.put(x, new ArrayList());
        }
        xy.get(x).add(y);
    }

    public void addCoor(int x, int y) {
        putCoor(x, y);
    }

    public void addCoor(int[] x, int[] y) {
        for (int i = 0; i < x.length; i++) {
            putCoor(x[i], y[i]);
        }
    }

    public void addCoor(Snake snake) {
        for (int i = 1; i < snake.body.size(); i++) {
            putCoor(snake.body.get(i)[0], snake.body.get(i)[1]);
        }
    }

    public void updateCoor(Snake snake) {
        xy.clear();
        addCoor(snake);
    }

    public boolean containsXY(Integer x, Integer y) {

        Object[] object = xy.keySet().toArray();
        for (int i = 0; i < object.length; i++) {
            Integer tempX = (Integer) object[i];
            //System.out.println(tempX);
            for (int j = 0; j < xy.get(tempX).size(); j++) {
                if (x == tempX && y == xy.get(tempX).get(j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public int totalPoint() {
        int result = 0;
        Object[] object = xy.keySet().toArray();
        for (int i = 0; i < object.length; i++) {
            Integer tempX = (Integer) object[i];
            for (int j = 0; j < xy.get(tempX).size(); j++) {
                result++;
            }
        }
        return result;
    }

    public int getSmallestX() {
        if (this.totalPoint() == 0) {
            return -1;
        }
        int[] x = this.getXPoint();
        int result = x[0];
        for (int i = 0; i < x.length; i++) {
            if (result > x[i]) {
                result = x[i];
            }
        }
        return result;
    }

    public int getLargestX() {
        if (this.totalPoint() == 0) {
            return -1;
        }
        int[] x = this.getXPoint();
        int result = x[0];
        for (int i = 0; i < x.length; i++) {
            if (result < x[i]) {
                result = x[i];
            }
        }
        return result;
    }

    public int getSmallestY() {
        if (this.totalPoint() == 0) {
            return -1;
        }
        int[] y = this.getYPoint();
        int result = y[0];
        for (int i = 0; i < y.length; i++) {
            if (result > y[i]) {
                result = y[i];
            }
        }
        return result;
    }

    public int getLargestY() {
        if (this.totalPoint() == 0) {
            return -1;
        }
        int[] y = this.getYPoint();
        int result = y[0];
        for (int i = 0; i < y.length; i++) {
            if (result < y[i]) {
                result = y[i];
            }
        }
        return result;
    }
}
