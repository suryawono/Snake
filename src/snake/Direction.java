/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

/**
 *
 * @author Quantum
 */
public class Direction {
    
    public static final int D_R=0;
    public static final int D_D=1;
    public static final int D_L=2;
    public static final int D_U=3;
    public static final String[] directionName={"right","down","left","up"};
    private int direction;
    
    public Direction(int direction){
        this.direction=direction;
    }
    
    public void setDirection(int d){
        if (d>=0 && d<=3){
            direction=d;
        }
    }
    
    public int getDirection(){
        return this.direction;
    }
}
