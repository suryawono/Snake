/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package food.util;

import snake.Board;

/**
 *
 * @author Quantum
 */
public class LifeTime{
    
    private long startTime;
    private long lifeTime;
    private long currentTime;
    private long tempTime;
    
    public LifeTime(long lifeTime){
        this.lifeTime=lifeTime;
        startTime=System.currentTimeMillis();
        currentTime=0;
    }
    
    public boolean isExpired(){
        if (Board.pause){
            startTime=System.currentTimeMillis();
            tempTime=currentTime;
            currentTime=0;
        } else {
            currentTime=System.currentTimeMillis()-startTime+tempTime;
        }
        if (currentTime<lifeTime){
            return false;
        }
        return true;
    }
}
