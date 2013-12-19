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
public class ShrinkPill extends Food {

    public ShrinkPill() {
        super(new Coordinate(),FoodSetting.F_SHRINKPILL_TIME,FoodSetting.F_SHRINKPILL_CHANCE,FoodSetting.F_SHRINKPILL_VALUE,FoodSetting.F_SHRINKPILL_FAT,FoodSetting.F_SHRINKPILL_HEALTH);
    }
    
    @Override
    public Coordinate makeCoordinate(int x,int y){
        Coordinate coordinate=new Coordinate();
        coordinate.addCoor(x, y);
        coordinate.addCoor(x+1,y);
        return coordinate;
    }
}
