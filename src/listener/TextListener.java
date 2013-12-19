/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package listener;

import java.awt.event.KeyEvent;
import javax.swing.JTextField;
import setting.ControlSetting;

/**
 *
 * @author SunFlower
 */
public class TextListener {
    
    public static void setControlText(JTextField field, int key) {
            field.setText(KeyEvent.getKeyText(key) + "");
    }
    
    public static void loadControlText(JTextField[] field){
        setControlText(field[0],ControlSetting.getValue(ControlSetting.CS_MOVE_UP));
        ControlSetting.putField(ControlSetting.CS_MOVE_UP, field[0]);
        setControlText(field[1],ControlSetting.getValue(ControlSetting.CS_MOVE_RIGHT));
        ControlSetting.putField(ControlSetting.CS_MOVE_RIGHT, field[1]);
        setControlText(field[2],ControlSetting.getValue(ControlSetting.CS_MOVE_DOWN));
        ControlSetting.putField(ControlSetting.CS_MOVE_DOWN, field[2]);
        setControlText(field[3],ControlSetting.getValue(ControlSetting.CS_MOVE_LEFT));
        ControlSetting.putField(ControlSetting.CS_MOVE_LEFT, field[3]);
        setControlText(field[4],ControlSetting.getValue(ControlSetting.CS_PAUSE));
        ControlSetting.putField(ControlSetting.CS_PAUSE, field[4]);
    }
}
