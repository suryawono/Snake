/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package food;

import base.Coordinate;
import base.Unit;
import food.util.LifeTime;
import snake.Board;

/**
 *
 * @author Quantum
 */
public class Food extends Unit{
    
    public int fat;
    public LifeTime lifeTime;
    public int value;
    public int health;
    
    public int chanceToSpam;//range from 0~100
    public int totalXYPoint;
    
    public Food(){
        super();
    }
    
    public Food(Coordinate coor,int lifeTime,int chanceToSpam,int value,int fat,int health){
        super();
        this.coor=coor;
        this.fat=fat;
        this.value=value;
        this.lifeTime=new LifeTime(lifeTime*(Board.delay/100));
        this.chanceToSpam=chanceToSpam;
        this.health=health;
    }
    
    public Coordinate makeCoordinate(int x,int y){
        return null;
    }

}
