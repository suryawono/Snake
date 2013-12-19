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
public class Bacon extends Food{
    
    public Bacon(){
        super(new Coordinate(),FoodSetting.F_BACON_TIME,FoodSetting.F_BACON_CHANCE,FoodSetting.F_BACON_VALUE,FoodSetting.F_CANDY_FAT,FoodSetting.F_BACON_HEALTH);
    }
    
    @Override
    public Coordinate makeCoordinate(int x,int y){
        Coordinate coordinate=new Coordinate();
        coordinate.addCoor(x, y);
        coordinate.addCoor(x+1,y);
        return coordinate;
    }
    
}
