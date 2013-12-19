/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grid;

import base.Unit;
import java.util.ArrayList;
import snake.Board;

/**
 *
 * @author Quantum
 */
public class ObstacleContainer extends Thread{
    
    public ArrayList<Unit> container;
    
    public ObstacleContainer(){
        container=new ArrayList();
    }
    
    public void buildGrid(int gridType){
        container=ObstacleBuilder.makeGrid(gridType);
        Board.map.addUnit(container);
    }
    
    public int size(){
        return container.size();
    }
    
    public Unit get(int index){
        return container.get(index);
    }
    
    @Override
    public void start(){
        
    }
}
