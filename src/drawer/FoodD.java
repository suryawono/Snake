/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package drawer;

import food.*;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Quantum
 */
public class FoodD {

    public static void drawFood(Graphics g, Food food, int dotSize) {
        if (food instanceof Apple) {
            drawApple(g, (Apple) food, dotSize);
        } else if (food instanceof PoisonApple) {
            drawPoisonApple(g, (PoisonApple) food, dotSize);
        } else if (food instanceof Bacon) {
            drawBacon(g, (Bacon) food, dotSize);
        } else if (food instanceof DietCoke) {
            drawDietCoke(g, (DietCoke) food, dotSize);
        } else if (food instanceof Candy) {
            drawCandy(g, (Candy) food, dotSize);
        } else if (food instanceof ShrinkPill) {
            drawShrinkPill(g, (ShrinkPill) food, dotSize);
        } else if (food instanceof Spinach) {
            drawSpinach(g, (Spinach) food, dotSize);
        } else if (food instanceof RatPoison) {
            drawRatPoison(g, (RatPoison) food, dotSize);
        }
    }

    public static void drawApple(Graphics g, Apple apple, int dotSize) {
        int x = apple.coor.getSmallestX();
        int y = apple.coor.getSmallestY();
        if (ImageResources.I_F_APPLE != null) {
            g.drawImage(ImageResources.I_F_APPLE, x * dotSize, y* dotSize, null);
        } else {
            g.setColor(Color.red);
            g.fillOval(x * dotSize, y * dotSize, dotSize, dotSize);
        }
    }

    private static void drawPoisonApple(Graphics g, PoisonApple poisonApple, int dotSize) {
        int x = poisonApple.coor.getSmallestX();
        int y = poisonApple.coor.getSmallestY();
        if (ImageResources.I_F_POISONAPPLE != null) {
            g.drawImage(ImageResources.I_F_POISONAPPLE,x * dotSize, y * dotSize, null);
        } else {
            g.setColor(Color.green);
            g.fillOval(x * dotSize, y * dotSize, dotSize, dotSize);
        }
    }

    private static void drawBacon(Graphics g, Bacon bacon, int dotSize) {
        int x = bacon.coor.getSmallestX();
        int y = bacon.coor.getSmallestY();
        if (ImageResources.I_F_BACON != null) {
            g.drawImage(ImageResources.I_F_BACON, x * dotSize, y * dotSize, null);
        } else {
            g.setColor(Color.yellow);
            g.fillOval(x * dotSize, y * dotSize, dotSize * 2, dotSize);
        }
    }

    public static void drawDietCoke(Graphics g, DietCoke dietCoke, int dotSize) {
        int x = dietCoke.coor.getSmallestX();
        int y = dietCoke.coor.getSmallestY();
        if (ImageResources.I_F_DIETCOKE != null) {
            g.drawImage(ImageResources.I_F_DIETCOKE, x * dotSize, y * dotSize, null);
        } else {
            g.setColor(new Color(255, 178, 86));
            g.fillOval(x * dotSize, y * dotSize, dotSize, dotSize);
        }
    }

    public static void drawCandy(Graphics g, Candy candy, int dotSize) {
        int x = candy.coor.getSmallestX();
        int y = candy.coor.getSmallestY();
        if (ImageResources.I_F_CANDY != null) {
            g.drawImage(ImageResources.I_F_CANDY, x * dotSize, y * dotSize, null);
        } else {
            g.setColor(Color.PINK);
            g.fillOval(x* dotSize, y * dotSize, dotSize, dotSize);
        }
    }

    public static void drawShrinkPill(Graphics g, ShrinkPill shrinkPill, int dotSize) {
        int x = shrinkPill.coor.getSmallestX();
        int y = shrinkPill.coor.getSmallestY();
        if (ImageResources.I_F_SHRINKPILL != null) {
            g.drawImage(ImageResources.I_F_SHRINKPILL, x * dotSize, y * dotSize, null);
        } else {
            g.setColor(Color.CYAN);
            g.fillOval(x * dotSize, y * dotSize, dotSize * 2, dotSize);
        }
    }

    public static void drawSpinach(Graphics g, Spinach spinach, int dotSize) {
        int x = spinach.coor.getSmallestX();
        int y = spinach.coor.getSmallestY();
        if (ImageResources.I_F_SPINACH != null) {
            g.drawImage(ImageResources.I_F_SPINACH, x * dotSize, y * dotSize, null);
        } else {
            g.setColor(Color.orange);
            g.fillOval(x * dotSize, y * dotSize, dotSize, dotSize);
        }
    }

    public static void drawRatPoison(Graphics g, RatPoison ratpoison, int dotSize) {
        int x = ratpoison.coor.getSmallestX();
        int y = ratpoison.coor.getSmallestY();
        if (ImageResources.I_F_RAT_POISON != null) {
            g.drawImage(ImageResources.I_F_RAT_POISON, x * dotSize, y * dotSize, null);
        } else {
            g.setColor(Color.darkGray);
            g.fillOval(x * dotSize, y* dotSize, dotSize, dotSize);
        }
    }
}
