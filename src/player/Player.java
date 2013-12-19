/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package player;

/**
 *
 * @author Quantum
 */
public class Player {
    private int value;
    
    public Player(){
        reset();
    }
    
    public final void reset(){
        this.value=0;
    }
    
    public void addValue(int value){
        this.value+=value;
    }
    
    public int getValue(){
        return this.value;
    }
    
    public void resetValue(){
        value=0;
    }
    
}
