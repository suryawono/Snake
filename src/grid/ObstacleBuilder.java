/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grid;

import grid.obstacle.Obstacle;
import grid.obstacle.OuterWall;
import grid.obstacle.Spike;
import java.util.ArrayList;
import snake.Board;

/**
 *
 * @author Quantum
 */
public class ObstacleBuilder {

    public static final int G_DEFAULT = 1;
    public static final int G_BORDER = 2;
    public static final int G_1 = 3;
    public static final int G_2 = 4;
    public static final int G_3 = 5;

    public static ArrayList makeGrid(int gridType) {
        ArrayList<Obstacle> wall;
        switch (gridType) {
            case G_DEFAULT:
                wall = make_G_DEFAULT();
                break;
            case G_BORDER:
                wall = make_G_BORDER();
                break;
            case G_1:
                wall = make_G_1();
                break;
            case G_2:
                wall = make_G_2();
                break;
            case G_3:
                wall = make_G_3();
                break;
            default:
                wall = null;
        }
        return wall;
    }

    private static ArrayList make_G_DEFAULT() {
        ArrayList<Obstacle> wall = new ArrayList();
        return wall;
    }

    private static ArrayList make_G_BORDER() {
        ArrayList<Obstacle> wall = new ArrayList();
        wall.add(new OuterWall());
        return wall;
    }

    private static ArrayList make_G_1() {
        ArrayList<Obstacle> wall = new ArrayList();
        wall.addAll(make_G_BORDER());
        for (int i = Board.maxY - 3; i >= 4; i--) {
            if ((i % 4 == 0) || (i % 5 == 0)) {
            } else {
                int n = Board.maxX / 10 * 9;
                wall.add(new Spike((int) (Board.maxX - n), i));
                wall.add(new Spike((int) (n), i - 1));
            }
        }
        return wall;
    }

    private static ArrayList make_G_2() {
        ArrayList<Obstacle> wall = new ArrayList();
        for (int i = Board.maxY - 3; i >= 4; i--) {
            if ((i % 4 == 0) || (i % 5 == 0)) {
            } else {
                int n = Board.maxX / 10 * 9;
                wall.add(new Spike((int) (Board.maxX - n), i));
                wall.add(new Spike((int) (n), i - 1));
            }
        }
        return wall;
    }

    private static ArrayList make_G_3() {
        ArrayList<Obstacle> wall = new ArrayList();
        for (int i = 2; i < Board.maxX - 1; i++) {
            if (i < Board.maxX / 3) {
                wall.add(new Spike(i, Board.maxY / 3));
                wall.add(new Spike(Board.maxX - i, Board.maxY / 3));
                wall.add(new Spike(i, Board.maxY / 3 * 2 + (Board.maxY % 3)));
                wall.add(new Spike(Board.maxX - i, Board.maxY / 3 * 2 + (Board.maxY % 3)));
            }
        }
        for (int i = 2; i < Board.maxY - 1; i++) {
            if (i < Board.maxY / 3) {
                wall.add(new Spike(Board.maxX / 3, i));
                wall.add(new Spike(Board.maxX / 3, Board.maxY - i));
                wall.add(new Spike(Board.maxX / 3 * 2 + (Board.maxX % 3), i));
                wall.add(new Spike(Board.maxX / 3 * 2 + (Board.maxX % 3), Board.maxY - i));
            }
        }
        return wall;
    }
}
