/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package renderer;

import java.awt.Color;
import java.awt.Graphics;
import snake.Direction;

/**
 *
 * @author Quantum
 */
public class SnakeD {

    public static final int T_H = 0;
    public static final int T_V = 1;
    public static final int T_RD = 2;
    public static final int T_DL = 3;
    public static final int T_LU = 4;
    public static final int T_UR = 5;
    public static final int T_HEAD = 10;
    public static final int T_HEAD_FACERIGHT = 11;
    public static final int T_HEAD_FACEDOWN = 12;
    public static final int T_HEAD_FACELEFT = 13;
    public static final int T_HEAD_FACEUP = 14;
    public static final int T_TAIL = 20;
    public static final int T_TAIL_RIGHT = 21;
    public static final int T_TAIL_DOWN = 22;
    public static final int T_TAIL_LEFT = 23;
    public static final int T_TAIL_UP = 24;

    public static void drawSnakeBody(Graphics g, int x, int y, int type, int dotSize) {
        x *= dotSize;
        y *= dotSize;
        int half_size = dotSize / 2;
        g.setColor(new Color(153, 51, 0));
        if (type == T_HEAD) {
            g.drawOval(x, y, dotSize, dotSize);
        } else if (type == T_H) {
            g.drawLine(x, y + half_size, x + dotSize, y + half_size);
        } else if (type == T_V) {
            g.drawLine(x + half_size, y, x + half_size, y + dotSize);
        } else if (type == T_RD) {
            int[] xPoint = {x + dotSize, x + half_size, x + half_size};
            int[] yPoint = {y + half_size, y + half_size, y + dotSize};
            g.drawPolyline(xPoint, yPoint, 3);
        } else if (type == T_DL) {
            int[] xPoint = {x, x + half_size, x + half_size};
            int[] yPoint = {y + half_size, y + half_size, y + dotSize};
            g.drawPolyline(xPoint, yPoint, 3);
        } else if (type == T_LU) {
            int[] xPoint = {x, x + half_size, x + half_size};
            int[] yPoint = {y + half_size, y + half_size, y};
            g.drawPolyline(xPoint, yPoint, 3);
        } else if (type == T_UR) {
            int[] xPoint = {x + dotSize, x + half_size, x + half_size};
            int[] yPoint = {y + half_size, y + half_size, y};
            g.drawPolyline(xPoint, yPoint, 3);
        }
    }

    public static void drawSnakeImage(Graphics g, int x, int y, int type, int dotSize) {
        x *= dotSize;
        y *= dotSize;
        switch (type) {
            case T_HEAD_FACERIGHT:
                g.drawImage(ImageResources.I_T_HEAD_FACERIGHT, x, y, dotSize, dotSize, null);
                break;
            case T_HEAD_FACEDOWN:
                g.drawImage(ImageResources.I_T_HEAD_FACEDOWN, x, y, dotSize, dotSize, null);
                break;
            case T_HEAD_FACELEFT:
                g.drawImage(ImageResources.I_T_HEAD_FACELEFT, x, y, dotSize, dotSize, null);
                break;
            case T_HEAD_FACEUP:
                g.drawImage(ImageResources.I_T_HEAD_FACEUP, x, y, dotSize, dotSize, null);
                break;
            case T_H:
                g.drawImage(ImageResources.I_T_H, x, y, dotSize, dotSize, null);
                break;
            case T_V:
                g.drawImage(ImageResources.I_T_V, x, y, dotSize, dotSize, null);

                break;
            case T_RD:
                g.drawImage(ImageResources.I_T_RD, x, y, dotSize, dotSize, null);
                break;
            case T_DL:
                g.drawImage(ImageResources.I_T_DL, x, y, dotSize, dotSize, null);
                break;
            case T_LU:
                g.drawImage(ImageResources.I_T_LU, x, y, dotSize, dotSize, null);
                break;
            case T_UR:
                g.drawImage(ImageResources.I_T_UR, x, y, dotSize, dotSize, null);
                break;
            case T_TAIL_RIGHT:
                if (ImageResources.stated) {
                    g.drawImage(ImageResources.I_T_TAIL_RIGHT, x, y, dotSize, dotSize, null);
                } else {
                    g.drawImage(ImageResources.I_T_TAIL_RIGHT_STATED, x, y, dotSize, dotSize, null);
                }
                break;
            case T_TAIL_DOWN:
                if (ImageResources.stated) {
                    g.drawImage(ImageResources.I_T_TAIL_DOWN, x, y, dotSize, dotSize, null);
                } else {
                    g.drawImage(ImageResources.I_T_TAIL_DOWN_STATED, x, y, dotSize, dotSize, null);
                }
                break;
            case T_TAIL_LEFT:
                if (ImageResources.stated) {
                    g.drawImage(ImageResources.I_T_TAIL_LEFT, x, y, dotSize, dotSize, null);
                } else {
                    g.drawImage(ImageResources.I_T_TAIL_LEFT_STATED, x, y, dotSize, dotSize, null);
                }
                break;
            case T_TAIL_UP:
                if (ImageResources.stated) {
                    g.drawImage(ImageResources.I_T_TAIL_UP, x, y, dotSize, dotSize, null);
                } else {
                    g.drawImage(ImageResources.I_T_TAIL_UP_STATED, x, y, dotSize, dotSize, null);
                }
                break;
        }
    }

    public static int getNeckType(int passDirection, int newDirection) {
        if (passDirection == Direction.D_R) {
            if (newDirection == Direction.D_U) {
                return SnakeD.T_LU;
            } else if (newDirection == Direction.D_D) {
                return SnakeD.T_DL;
            }
            return SnakeD.T_H;
        } else if (passDirection == Direction.D_D) {
            if (newDirection == Direction.D_R) {
                return SnakeD.T_UR;
            } else if (newDirection == Direction.D_L) {
                return SnakeD.T_LU;
            }
            return SnakeD.T_V;
        } else if (passDirection == Direction.D_U) {
            if (newDirection == Direction.D_R) {
                return SnakeD.T_RD;
            } else if (newDirection == Direction.D_L) {
                return SnakeD.T_DL;
            }
            return SnakeD.T_V;
        } else if (passDirection == Direction.D_L) {
            if (newDirection == Direction.D_U) {
                return SnakeD.T_UR;
            } else if (newDirection == Direction.D_D) {
                return SnakeD.T_RD;
            }
            return SnakeD.T_H;
        }
        return -1;
    }

    public static int getTailType(Integer[] tail, Integer[] after) {
        if (tail[0] == after[0]) {
            if (tail[1] > after[1]) {
                return T_TAIL_DOWN;
            } else {
                return T_TAIL_UP;
            }
        } else if (tail[1] == after[1]) {
            if (tail[0] > after[0]) {
                return T_TAIL_RIGHT;
            } else {
                return T_TAIL_LEFT;
            }
        }
        return -1;
    }
}
