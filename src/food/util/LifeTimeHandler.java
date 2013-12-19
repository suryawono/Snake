/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package food.util;

import food.Food;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import snake.Board;

/**
 *
 * @author Quantum
 */
public class LifeTimeHandler extends Thread{
    
    private ArrayList<Food> foodList;
    private boolean alive=true;
    
    @Override
    public void run(){
        while (alive){
            try {
                Thread.sleep(Board.delay);
            } catch (InterruptedException ex) {
                Logger.getLogger(LifeTimeHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
            removeExpiredFood();
        }
    }
    
    public LifeTimeHandler(ArrayList<Food> foodList){
        this.foodList=foodList;
    }
    
    public void addFood(Food food){
        foodList.add(food);
    }
    
    public boolean isExpired(Food food){
        return foodList.get(foodList.indexOf(food)).lifeTime.isExpired();
    }
    
    public void remove(Food food){
        foodList.remove(food);
    }
    
    public ArrayList getFoodList(){
        return this.foodList;
    }
    
    
    public void removeExpiredFood(){
        for (int i=foodList.size()-1;i>=0;i--){
            if ((!foodList.isEmpty()) && isExpired(foodList.get(i))){
                Board.map.removeUnit(foodList.get(i));
                remove(foodList.get(i));
            }
        }
    }
    
    public void shutDown(){
        alive=false;
    }
}
