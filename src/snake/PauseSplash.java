/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author Surya Wono
 */
public class PauseSplash extends BufferedImage{

    public PauseSplash() {
         super(45, 16, BufferedImage.TYPE_INT_RGB);
         drawImg();
    }
    
    protected void drawImg(){
        Graphics g=getGraphics();
        g.setColor(new Color(1.0f,1.0f,1.0f,1.0f));
        g.fillRect(0, 0, 75, 16);
        g.setColor(new Color(1.0f,0.0f,0.0f,1.0f));
        g.drawString("Pause", 0, 12);
    }
}
