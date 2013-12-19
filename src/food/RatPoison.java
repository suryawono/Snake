/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package food;

import base.Coordinate;
import food.util.FoodSetting;

/**
 *
 * @author Quantum
 */
public class RatPoison extends Food{
    
    public RatPoison(){
        super(new Coordinate(),FoodSetting.F_RAT_POISON_TIME,FoodSetting.F_RAT_POISON_CHANCE,FoodSetting.F_RAT_POISON_VALUE,FoodSetting.F_RAT_POISON_FAT,FoodSetting.F_RAT_POISON_HEALTH);
    }
    
    @Override
    public Coordinate makeCoordinate(int x,int y){
        Coordinate coordinate=new Coordinate();
        coordinate.addCoor(x, y);
        return coordinate;
    }
}
