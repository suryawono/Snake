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
public class PoisonApple extends Food{
    
    public PoisonApple(){
        super(new Coordinate(),FoodSetting.F_POISONAPPLE_TIME,FoodSetting.F_POISONAPPLE_CHANCE,FoodSetting.F_POISONAPPLE_VALUE,FoodSetting.F_POISONAPPLE_FAT,FoodSetting.F_POISONAPPLE_HEALTH);
    }
    
    @Override
    public Coordinate makeCoordinate(int x,int y){
        Coordinate coordinate=new Coordinate();
        coordinate.addCoor(x, y);
        return coordinate;
    }
}
