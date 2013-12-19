/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package setting;

import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;

/**
 *
 * @author SunFlower
 */
public class ControlSetting {

    public static final int CS_MOVE_RIGHT = 0;
    public static final int CS_MOVE_DOWN = 1;
    public static final int CS_MOVE_LEFT = 2;
    public static final int CS_MOVE_UP = 3;
    public static final int CS_PAUSE = 4;
    //keyType using what textField
    private static HashMap<Integer, JTextField> targetTextField = new HashMap();
    //keyType using what VK key
    private static HashMap<Integer, Integer> keyValue = new HashMap();
    private static Properties p = new Properties();

    public static void load() {
        try {
            InputStream inp = new FileInputStream("control.ini");
            p.load(inp);
        } catch (IOException ex) {
            p.put("moveRight", KeyEvent.VK_RIGHT + "");
            p.put("moveLeft", KeyEvent.VK_LEFT + "");
            p.put("moveDown", KeyEvent.VK_DOWN + "");
            p.put("moveUp", KeyEvent.VK_UP + "");
            p.put("pause", KeyEvent.VK_SPACE + "");
            try {
                p.store(new FileOutputStream("control.ini"), "");
            } catch (IOException ex1) {
                Logger.getLogger(ControlSetting.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            keyValue.put(CS_MOVE_RIGHT, Integer.parseInt(p.getProperty("moveRight")));
            keyValue.put(CS_MOVE_DOWN, Integer.parseInt(p.getProperty("moveDown")));
            keyValue.put(CS_MOVE_LEFT, Integer.parseInt(p.getProperty("moveLeft")));
            keyValue.put(CS_MOVE_UP, Integer.parseInt(p.getProperty("moveUp")));
            keyValue.put(CS_PAUSE, Integer.parseInt(p.getProperty("pause")));
        }
    }

    public static void save() {
        p.put("moveRight",getValue(CS_MOVE_RIGHT)+ "");
        p.put("moveLeft", getValue(CS_MOVE_LEFT) + "");
        p.put("moveDown", getValue(CS_MOVE_DOWN) + "");
        p.put("moveUp", getValue(CS_MOVE_UP) + "");
        p.put("pause", getValue(CS_PAUSE) + "");
        try {
            p.store(new FileOutputStream("control.ini"), "");
        } catch (IOException ex) {
            Logger.getLogger(ControlSetting.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void setKey(int keyType, int value) {
        keyValue.put(keyType, value);
    }

    public static int getValue(int keyType) {
        return keyValue.get(keyType);
    }
    
    public static void putField(int keyType,JTextField textField){
        targetTextField.put(keyType, textField);
    }
}
