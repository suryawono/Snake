/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package function;

import java.util.HashMap;

/**
 *
 * @author Quantum
 */
public class ToString {
    
    public static String arrayInt2DToString(int[][] arrays){
        String result="";
        for (int i=0;i<arrays.length;i++){
            for (int j=0;j<arrays[i].length;j++){
                result+=arrays[i][j];
            }
            result+="\n";
        }
        return result;
    }
    
    public static String hashMapToString(HashMap h){
        String result="";
        Object[] setOfX=h.keySet().toArray();
        for (int i=0;i<setOfX.length;i++){
            result+=setOfX[i]+","+h.get((Integer)setOfX[i])+" ";
        }
        return result;
    }
}
