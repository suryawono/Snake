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
public class Apple extends Food{
    
    public Apple(){
        super(new Coordinate(),FoodSetting.F_APPLE_TIME,FoodSetting.F_APPLE_CHANCE,FoodSetting.F_APPLE_VALUE,FoodSetting.F_APPLE_FAT,FoodSetting.F_APPLE_HEALTH);
    }
    
    @Override
    public Coordinate makeCoordinate(int x,int y){
        Coordinate coordinate=new Coordinate();
        coordinate.addCoor(x, y);
        return coordinate;
    }
}
