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
public class DietCoke extends Food{
    
    public DietCoke(){
        super(new Coordinate(),FoodSetting.F_DIETCOKE_TIME,FoodSetting.F_DIETCOKE_CHANCE,FoodSetting.F_DIETCOKE_VALUE,FoodSetting.F_DIETCOKE_VALUE,FoodSetting.F_DIETCOKE_HEALTH);
    }
    
    @Override
    public Coordinate makeCoordinate(int x,int y){
        Coordinate coordinate=new Coordinate();
        coordinate.addCoor(x, y);
        return coordinate;
    }
}
