/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package base;

/**
 *
 * @author Quantum
 */
public abstract class Unit {
    public Coordinate coor;
    
    public Unit(){}
    
    public Coordinate getCoor(){
        return this.coor;
    }
        
    public void setCoor(Coordinate coor){
        this.coor=coor;
    }
}
