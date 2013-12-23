/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import base.Coordinate;
import base.Unit;
import food.Food;
import java.util.ArrayList;
import renderer.SnakeD;

/**
 *
 * @author Quantum
 */
public class Snake extends Unit {

    public ArrayList<Integer[]> body;
    private Direction direction;
    private Direction passDirection;
    public int xHead;
    public int yHead;
    private int bodyToGrow = 0;
    public HealthBar health;
    
    public Snake() {
        reset();
    }

    public final void reset() {
        health=new HealthBar(100,100);
        body = new ArrayList();
        coor = new Coordinate();
        direction = new Direction(Direction.D_L);
        passDirection = new Direction(Direction.D_L);
    }

    public void init(int length) {
        int x = Board.maxX / 2;
        int y = Board.maxY / 2;
        body.add(makeBodyInstance(x, y, SnakeD.T_HEAD_FACERIGHT));
        for (int i = 1; i < length; i++) {
            body.add(makeBodyInstance(x + i, y, SnakeD.T_H));
        }
        coor.addCoor(this);
    }

    public Integer[] makeBodyInstance(int x, int y, int type) {
        Integer[] n = new Integer[3];
        n[0] = x;
        n[1] = y;
        n[2] = type;
        return n;
    }

    public void move() {
        if (bodyToGrow > 0) {
            bodyToGrow--;
        } else {
            body.remove(body.size() - 1);
            while (bodyToGrow < 0) {
                if (body.size() >= 3) {
                    body.remove(body.size() - 1);
                }
                bodyToGrow++;
            }
            body.get(body.size() - 1)[2] = SnakeD.getTailType(body.get(body.size() - 1), body.get(body.size() - 2));
        }
        growBody(1);
    }

    public void changeDirection(int direction) {
        this.passDirection.setDirection(this.direction.getDirection());
        this.direction.setDirection(direction);
    }

    public Direction getDirectionObj() {
        return this.direction;
    }

    public int getDirection() {
        return this.direction.getDirection();
    }

    public boolean isCollision() {
        Unit[] unit = Board.map.getUnitArray();
        for (int i = 0; i < unit.length; i++) {
            if (!(unit[i] instanceof Food) && unit[i].coor.containsXY(xHead, yHead)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean isDeath(){
        return (isCollision() || (health.getHealth()<=0));
    }
    
    public void eat(Food food) {
        bodyToGrow += food.fat;
        Board.player.addValue(food.value);
        //System.out.println("Score=" + Board.player.getValue());
        health.addHealth(food.health);
        //System.out.println(health.getHealth());
        //System.out.println(bodyToGrow);
    }

    public void growBody(int length) {
        for (int i = 0; i < length; i++) {
            int x = body.get(0)[0];
            int y = body.get(0)[1];
            if (direction.getDirection() == Direction.D_R) {
                body.add(0, makeBodyInstance(x + 1, y, SnakeD.T_HEAD_FACERIGHT));
            } else if (direction.getDirection() == Direction.D_D) {
                body.add(0, makeBodyInstance(x, y + 1, SnakeD.T_HEAD_FACEDOWN));
            } else if (direction.getDirection() == Direction.D_L) {
                body.add(0, makeBodyInstance(x - 1, y, SnakeD.T_HEAD_FACELEFT));
            } else if (direction.getDirection() == Direction.D_U) {
                body.add(0, makeBodyInstance(x, y - 1, SnakeD.T_HEAD_FACEUP));
            }
            body.get(1)[2] = SnakeD.getNeckType(passDirection.getDirection(), direction.getDirection());
            changeDirection(this.getDirection());
            xHead = body.get(0)[0];
            yHead = body.get(0)[1];
            if (xHead<0){
                xHead=Board.maxX;
                body.get(0)[0]=xHead;
            }
            if (xHead>Board.maxX){
                xHead=0;
                body.get(0)[0]=xHead;
            }
            if (yHead<0){
                yHead=Board.maxY;
                body.get(0)[1]=yHead;
            }
            if (yHead>Board.maxY){
                yHead=0;
                body.get(0)[1]=yHead;
            }
        }
        coor.updateCoor(this);
    }
}
