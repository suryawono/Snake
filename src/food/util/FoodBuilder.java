/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package food.util;

import base.Coordinate;
import food.*;
import function.MyRandom;
import java.util.Random;
import java.util.Stack;
import snake.Board;

/**
 *
 * @author Quantum
 */
public class FoodBuilder {

    //score=1   grow=1      chance=17   time=3500   health=5
    public static final int F_APPLE = 1;   
    //score=-1  grow=1      chance=10   time=7500   health=-5
    public static final int F_POISONAPPLE = 2; 
    //score=5   grow=5      chance=5    time=2500   health=5
    public static final int F_BACON = 3;        
    //score=1   grow=0      chance=8    time=3500   health=-1
    public static final int F_DIETCOKE = 4;     
    //score=10  grow=3      chance=1    time=3000   health=10
    public static final int F_CANDY = 5;      
    //score=0   grow=-10    chance=3    time=3250    health=-50
    public static final int F_SHRINKPILL = 6;
    //score=5   grow=2    chance=5    time=3500    health=40
    public static final int F_SPINACH = 7;
    //score=-5   grow=0    chance=7    time=2500    health=-25
    public static final int F_RAT_POISON = 8;     
    //score=2   grow=1      chance=17   time=3500   health=1
    public static final int F_BANANA = 9;  
    /*
     * How to add new Food? make the class and extends Food then add the food
     * code here, add case at makeFood method, change static variable TOTAL_TYPE
     * at FoodContainer to total current total food, add the food drawer at
     * FoodD class
     */

    public static Stack makeFood(int type) {
        Stack result = new Stack();
        Random r = new Random();
        Food food;
        switch (type) {
            case F_APPLE:
                food = new Apple();
                break;
            case F_POISONAPPLE:
                food = new PoisonApple();
                break;
            case F_BACON:
                food = new Bacon();
                break;
            case F_DIETCOKE:
                food = new DietCoke();
                break;
            case F_CANDY:
                food = new Candy();
                break;
            case F_SHRINKPILL:
                food = new ShrinkPill();
                break;
            case F_SPINACH:
                food = new Spinach();
                break;
            case F_RAT_POISON:
                food = new RatPoison();
                break;
            case F_BANANA:
                food = new Banana();
                break;
            default:
                food = new Food();
        }
        if (isChanceHitted(food.chanceToSpam)) {
            boolean isValid;
            Coordinate coor;
            do {
                coor = food.makeCoordinate(r.nextInt(Board.maxX), r.nextInt(Board.maxY));
                isValid = Board.map.isCoordinateValid(coor);
            } while (!isValid);
            food.setCoor(coor);
            result.push(food);
            result.push(true);
        } else {
            result.push(false);
        }
        return result;
    }

    public static boolean isChanceHitted(int chance) {
        return MyRandom.hitRandom(chance);
    }
}
