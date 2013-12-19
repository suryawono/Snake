/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package function;

import java.util.Random;

/**
 *
 * @author Quantum
 */
public class MyRandom {
    
    //percent 0~100
    public static boolean hitRandom(int percent){
        Random r=new Random();
        int hit=r.nextInt(100)+1;
        for (int i=1;i<=percent;i++){
            if (r.nextInt(100)+1==hit){
             return true;   
            }
        }
        return false;
    }
}
