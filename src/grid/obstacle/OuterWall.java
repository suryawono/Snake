/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grid.obstacle;

import base.Coordinate;
import snake.Board;

/**
 *
 * @author Quantum
 */
public class OuterWall extends Spike{
    
    public OuterWall(){
        this.setCoor(this.makeCoordinate());
    }
    
    private Coordinate makeCoordinate(){
        Coordinate coordinate=new Coordinate();
        for (int i=0;i<=Board.maxX;i++){
            coordinate.addCoor(i, 0);
            coordinate.addCoor(i, Board.maxY);
        }
        for (int i=0;i<=Board.maxY;i++){
            coordinate.addCoor(0, i);
            coordinate.addCoor(Board.maxX, i);
        }
        return coordinate;
    }
}
