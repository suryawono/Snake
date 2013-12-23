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
public class Banana extends Food{
    
    public Banana(){
        super(new Coordinate(),FoodSetting.F_BANANA_TIME,FoodSetting.F_BANANA_CHANCE,FoodSetting.F_BANANA_VALUE,FoodSetting.F_BANANA_FAT,FoodSetting.F_BANANA_HEALTH);
    }
    
    @Override
    public Coordinate makeCoordinate(int x,int y){
        Coordinate coordinate=new Coordinate();
        coordinate.addCoor(x, y);
        return coordinate;
    }
}
