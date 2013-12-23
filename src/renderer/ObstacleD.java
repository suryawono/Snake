/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package renderer;

import base.Unit;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Quantum
 */
public class ObstacleD {

    public static void drawObstacle(Graphics g, Unit obstacle, int dotSize) {
        int[] x = obstacle.coor.getXPoint();
        int[] y = obstacle.coor.getYPoint();
        g.setColor(Color.black);
        for (int i = 0; i < x.length; i++) {
            if (ImageResources.I_O_SPIKE != null) {
                g.drawImage(ImageResources.I_O_SPIKE, x[i] * dotSize, y[i] * dotSize, dotSize, dotSize, null);
            } else {
                g.drawLine(x[i] * dotSize, y[i] * dotSize, x[i] * dotSize + dotSize, y[i] * dotSize + dotSize);
                g.drawLine(x[i] * dotSize, y[i] * dotSize + dotSize, x[i] * dotSize + dotSize, y[i] * dotSize);
            }
        }
    }
}
