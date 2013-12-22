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
public class Renderer {

    public static void drawBlank(Graphics g, int x, int y, int dotSize, Color color) {
        g.setColor(color);
        g.fillRect(x * dotSize, y * dotSize, dotSize, dotSize);
    }

    public static void drawBlank(Graphics g, Unit unit, int dotSize, Color color) {
        g.setColor(color);
        int[] x = unit.coor.getXPoint();
        int[] y = unit.coor.getYPoint();
        for (int i = 0; i < x.length; i++) {
            g.fillRect(x[i] * dotSize, y[i] * dotSize, dotSize, dotSize);
        }

    }
}
