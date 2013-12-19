/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grid.obstacle;

import base.Coordinate;

/**
 *
 * @author Quantum
 */
public class Spike extends Obstacle{
    
    public Spike(){
        this.coor=new Coordinate();
    }  
    
    public Spike(int x,int y){
        this.coor=new Coordinate(x,y);
    }
}
