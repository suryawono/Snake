/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package food;

import base.Coordinate;
import food.util.FoodSetting;

/**
 *
 * @author TOSHIBA L840
 */
public class Spinach extends Food{
    
    public Spinach(){
        super(new Coordinate(),FoodSetting.F_SPINACH_TIME,FoodSetting.F_SPINACH_CHANCE,FoodSetting.F_SPINACH_VALUE,FoodSetting.F_SPINACH_FAT,FoodSetting.F_SPINACH_HEALTH);
    }
    
    @Override
    public Coordinate makeCoordinate(int x,int y){
        Coordinate coordinate=new Coordinate();
        coordinate.addCoor(x, y);
        return coordinate;
    }
}
