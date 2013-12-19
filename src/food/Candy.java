/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package food;

import base.Coordinate;
import food.util.FoodSetting;

/**
 *
 * @author SunFlower
 */
public class Candy extends Food{
    
    
    public Candy(){
        super(new Coordinate(),FoodSetting.F_CANDY_TIME,FoodSetting.F_CANDY_CHANCE,FoodSetting.F_BACON_VALUE,FoodSetting.F_CANDY_FAT,FoodSetting.F_CANDY_HEALTH);
    }
    
    @Override
    public Coordinate makeCoordinate(int x,int y){
        Coordinate coordinate=new Coordinate();
        coordinate.addCoor(x, y);
        return coordinate;
    }
}
