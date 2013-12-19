/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package food.util;

import base.Unit;
import food.Food;
import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;
import snake.Board;
import snake.Snake;

/**
 *
 * @author Quantum
 */
public class FoodContainer extends Thread {

    private static final int TOTAL_TYPE = 8;
    private ArrayList<Food> container;
    private LifeTimeHandler lth;
    private int foodLimit;
    private Snake snake;
    private boolean alive=true;

    @Override
    public void run() {
        lth.start();
        while (alive) {
            try {
                Thread.sleep(Board.delay);
                if (!Board.pause) {
                    spamFood();
                }
            } catch (InterruptedException ex) {
            } catch (NullPointerException npe) {
                container = new ArrayList();
                lth.shutDown();
                lth = new LifeTimeHandler(container);
                lth.start();
                Board.map.removeUnit(this.getFood());
                System.out.println(npe);
            }
        }
    }

    public FoodContainer(int foodLimit, Snake snake) {
        container = new ArrayList();
        lth = new LifeTimeHandler(container);
        this.snake = snake;
        this.foodLimit = foodLimit;
    }

    public void spamFood() throws NullPointerException {
        if (container.size() <= foodLimit) {
            Random r = new Random();
            int numberOfFood = r.nextInt(foodLimit - container.size() + 1);
            for (int i = 0; i < numberOfFood; i++) {
                Stack foodMaker = FoodBuilder.makeFood(r.nextInt(TOTAL_TYPE) + 1);
                if ((boolean) foodMaker.pop()) {
                    Food food = (Food) foodMaker.pop();
                    container.add(food);
                    Board.map.addUnit(food);
                    //System.out.println("added");
                }
            }
        }
        //System.out.println("size=" + container.size());
        //System.out.println(c++);
    }

    public int size() {
        return container.size();
    }

    public Food get(int index) {
        return container.get(index);
    }

    public Food getEaten() {
        Unit[] unit = Board.map.getUnitArray();
        for (int i = 0; i < unit.length; i++) {
            if ((unit[i] instanceof Food) && unit[i].coor.containsXY(snake.xHead, snake.yHead)) {
                return (Food) unit[i];
            }
        }
        return null;
    }

    public void eatHandling(Food food) {
        if (food != null) {
            snake.eat(food);
            Board.map.removeUnit(food);
            container.remove(food);
        }
    }

    public Food[] getFood() {
        Object[] unit = container.toArray();
        Food[] blank = new Food[unit.length];
        for (int i = 0; i < unit.length; i++) {
            blank[i] = (Food) unit[i];
        }
        return blank;
    }
    
    public void shutDown(){
        alive=false;
        lth.shutDown();
    }
}
