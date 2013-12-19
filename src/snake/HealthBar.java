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
 * @author SunFlower
 */
public class HealthBar extends BufferedImage {

    private int maxLength;
    private int maxHealth;
    private int currentHealth;
    private double percent;

    public HealthBar(int length, int maxHealth) {
        super(length, 16, BufferedImage.TYPE_INT_RGB);
        maxLength = length - 2;
        this.maxHealth = maxHealth;
        setHealth(maxHealth);
    }

    private void setPercent(double percent) {
        this.percent = percent;
        if (this.percent >= 100) {
            this.percent = 100;
        }
        updateHealth();
        drawBar();
    }

    private void updateHealth() {
        this.currentHealth = (int) (percent * maxHealth);
    }

    private void updateHealthForPercent() {
        this.percent = currentHealth * 1.0 / maxHealth * 100;
        drawBar();
    }

    private void setHealth(int health) {
        this.currentHealth = health;
        if (currentHealth >= maxHealth) {
            currentHealth = maxHealth;
        }
        updateHealthForPercent();
    }

    public void reduceHealth(double percent) {
        setPercent(this.percent - percent);
    }

    public void reduceHealth(int health) {
        setHealth(this.currentHealth - health);
    }

    public void addHealth(double percent) {
        reduceHealth(percent * -1);
    }

    public void addHealth(int health) {
        reduceHealth(health * -1);
    }

    public int getHealth() {
        return currentHealth;
    }

    private void initBarFrame() {
        Graphics g = getGraphics();
        g.setColor(Color.white);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        g.setColor(new Color(255, 200, 0));
        int[] x = {0, maxLength, maxLength, 0};
        int[] y = {0, 0, this.getHeight() - 1, this.getHeight() - 1};
        g.drawPolygon(x, y, x.length);
    }

    protected void drawBar() {
        initBarFrame();
        Graphics g = getGraphics();
        if (percent >= 60) {
            g.setColor(Color.green);
        } else if (percent > 30) {
            g.setColor(Color.yellow);
        } else {
            g.setColor(Color.red);
        }
        int width = maxLength - 1;
        width = (int) Math.ceil(width * (percent / 100));
        g.fillRect(1, 1, width, this.getHeight() - 2);
        g.setColor(Color.black);
        g.drawString(currentHealth + "/" + maxHealth, 10, 12);
    }
}
