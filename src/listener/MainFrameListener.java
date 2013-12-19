/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package listener;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import setting.ControlSetting;

/**
 *
 * @author SunFlower
 */
public class MainFrameListener extends WindowAdapter{
    
    @Override
    public void windowClosing(WindowEvent e){
        ControlSetting.save();
    }
}
