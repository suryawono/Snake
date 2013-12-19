/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package drawer;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

/**
 *
 * @author SunFlower
 */
public class ImageResources {

    public static BufferedImage I_T_HEAD_FACERIGHT;
    public static BufferedImage I_T_HEAD_FACEDOWN;
    public static BufferedImage I_T_HEAD_FACELEFT;
    public static BufferedImage I_T_HEAD_FACEUP;
    public static BufferedImage I_T_TAIL_RIGHT;
    public static BufferedImage I_T_TAIL_DOWN;
    public static BufferedImage I_T_TAIL_LEFT;
    public static BufferedImage I_T_TAIL_UP;
    public static BufferedImage I_T_V;
    public static BufferedImage I_T_H;
    public static BufferedImage I_T_TAIL_RIGHT_STATED;
    public static BufferedImage I_T_TAIL_DOWN_STATED;
    public static BufferedImage I_T_TAIL_LEFT_STATED;
    public static BufferedImage I_T_TAIL_UP_STATED;
    public static BufferedImage I_T_V_STATED;
    public static BufferedImage I_T_H_STATED;
    public static BufferedImage I_T_RD;
    public static BufferedImage I_T_DL;
    public static BufferedImage I_T_LU;
    public static BufferedImage I_T_UR;
    public static BufferedImage I_F_APPLE;
    public static BufferedImage I_F_POISONAPPLE;
    public static BufferedImage I_F_BACON;
    public static BufferedImage I_F_DIETCOKE;
    public static BufferedImage I_F_CANDY;
    public static BufferedImage I_F_SHRINKPILL;
    public static BufferedImage I_F_SPINACH;
    public static BufferedImage I_F_RAT_POISON;
    public static BufferedImage I_O_SPIKE;
    public static BufferedImage I_T_TONGUE_1_UP;
    public static BufferedImage I_T_TONGUE_1_RIGHT;
    public static BufferedImage I_T_TONGUE_1_DOWN;
    public static BufferedImage I_T_TONGUE_1_LEFT;
    public static BufferedImage I_T_TONGUE_2_UP;
    public static BufferedImage I_T_TONGUE_2_RIGHT;
    public static BufferedImage I_T_TONGUE_2_DOWN;
    public static BufferedImage I_T_TONGUE_2_LEFT;
    public static BufferedImage I_R_WINDOW_ICON;
    public static BufferedImage I_R_DIE_SNAKE;
    public static boolean stated = true;//for animation

    public static void LoadImage() throws IOException {
        ImageResources a = new ImageResources();
        String folder;
        URL resource;
        //-Snake
        folder = "/resources/picture/snake/";
        resource = a.getClass().getResource(folder + "Head.png");
        BufferedImage temp = ImageIO.read(resource);
        I_T_HEAD_FACERIGHT = ImageResources.rotateMyImage(temp, 90.0);
        I_T_HEAD_FACEDOWN = ImageResources.rotateMyImage(temp, 180.0);
        I_T_HEAD_FACELEFT = ImageResources.rotateMyImage(temp, 270.0);
        I_T_HEAD_FACEUP = ImageResources.rotateMyImage(temp, 0.0);
        resource = a.getClass().getResource(folder + "Body.png");
        temp = ImageIO.read(resource);
        I_T_V = temp;
        I_T_H = rotate90ToLeft(temp);
        resource = a.getClass().getResource(folder + "Bend.png");
        temp = ImageIO.read(resource);
        I_T_RD = temp;
        I_T_DL = rotate90ToRight(temp);
        I_T_LU = rotate180(temp);
        I_T_UR = rotate90ToLeft(temp);
        resource = a.getClass().getResource(folder + "Tail.png");
        temp = ImageIO.read(resource);
        I_T_TAIL_RIGHT = rotate90ToLeft(temp);
        I_T_TAIL_DOWN = temp;
        I_T_TAIL_LEFT = rotate90ToRight(temp);
        I_T_TAIL_UP = rotate180(temp);

        I_T_TAIL_RIGHT_STATED = flipVertical(I_T_TAIL_RIGHT);
        I_T_TAIL_DOWN_STATED = flipHorizontal(I_T_TAIL_DOWN);
        I_T_TAIL_LEFT_STATED = flipVertical(I_T_TAIL_LEFT);
        I_T_TAIL_UP_STATED = flipHorizontal(I_T_TAIL_UP);
        I_T_V_STATED = flipHorizontal(I_T_V);
        I_T_H_STATED = flipVertical(I_T_H);

        resource = a.getClass().getResource(folder + "Tongue Body.png");
        temp = ImageIO.read(resource);
        I_T_TONGUE_1_UP = rotate90ToLeft(temp);
        I_T_TONGUE_1_RIGHT = temp;
        I_T_TONGUE_1_DOWN = rotate90ToRight(temp);
        I_T_TONGUE_1_LEFT = rotate180(temp);
        resource = a.getClass().getResource(folder + "Tongue End.png");
        temp = ImageIO.read(resource);
        I_T_TONGUE_2_UP = rotate90ToLeft(temp);
        I_T_TONGUE_2_RIGHT = temp;
        I_T_TONGUE_2_DOWN = rotate90ToRight(temp);
        I_T_TONGUE_2_LEFT = rotate180(temp);

        //-Food
        folder = "/resources/picture/food/";
        resource = a.getClass().getResource(folder + "Apple.png");
        I_F_APPLE = ImageIO.read(resource);
        resource = a.getClass().getResource(folder + "Poisonous Apple.png");
        I_F_POISONAPPLE = ImageIO.read(resource);
        resource = a.getClass().getResource(folder + "Bacon.png");
        I_F_BACON = ImageIO.read(resource);
        resource = a.getClass().getResource(folder + "Diet Coke.png");
        I_F_DIETCOKE = ImageIO.read(resource);
        resource = a.getClass().getResource(folder + "Candy.png");
        I_F_CANDY = ImageIO.read(resource);
        resource = a.getClass().getResource(folder + "Shrink Pill.png");
        I_F_SHRINKPILL = ImageIO.read(resource);
        resource = a.getClass().getResource(folder + "Spinach.png");
        I_F_SPINACH = ImageIO.read(resource);
        resource = a.getClass().getResource(folder + "Rat Poison.png");
        I_F_RAT_POISON = ImageIO.read(resource);

        //-Obstacle
        folder = "/resources/picture/obstacle/";
        resource = a.getClass().getResource(folder + "Spike.png");
        I_O_SPIKE = ImageIO.read(resource);

        //Etc
        folder = "/resources/picture/etc/";
        resource = a.getClass().getResource(folder + "Window Icon.png");
        I_R_WINDOW_ICON = ImageIO.read(resource);
        resource = a.getClass().getResource(folder + "Die Icon.png");
        I_R_DIE_SNAKE = ImageIO.read(resource);
    }

    public static BufferedImage rotate180(BufferedImage inputImage) {
//We use BufferedImage because it’s provide methods for pixel manipulation
        int width = inputImage.getWidth(); //the Width of the original image
        int height = inputImage.getHeight();//the Height of the original image

        BufferedImage returnImage = new BufferedImage(width, height, inputImage.getType());
//we created new BufferedImage, which we will return in the end of the program
//it set up it to the same width and height as in original image
// inputImage.getType() return the type of image ( if it is in RBG, ARGB, etc. )

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                returnImage.setRGB(width - x - 1, height - y - 1, inputImage.getRGB(x, y));

            }
        }
//so we used two loops for getting information from the whole inputImage
//then we use method setRGB by whitch we sort the pixel of the return image
//the first two parametres is the X and Y location of the pixel in returnImage and the last one is the //source pixel on the inputImage
//why we put width – x – 1 and height –y – 1 is hard to explain for me, but when you rotate image by //180degree the pixel with location [0, 0] will be in [ width, height ]. The -1 is for not to go out of
//Array size ( remember you always start from 0 so the last index is lower by 1 in the width or height
//I enclose Picture for better imagination  ... hope it help you
        return returnImage;
//and the last return the rotated image

    }

    public static BufferedImage rotate90ToLeft(BufferedImage inputImage) {
//The most of code is same as before
        int width = inputImage.getWidth();
        int height = inputImage.getHeight();
        BufferedImage returnImage = new BufferedImage(height, width, inputImage.getType());
//We have to change the width and height because when you rotate the image by 90 degree, the
//width is height and height is width :)

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                returnImage.setRGB(y, width - x - 1, inputImage.getRGB(x, y));
//Again check the Picture for better understanding
            }
        }
        return returnImage;

    }

    public static BufferedImage rotate90ToRight(BufferedImage inputImage) {
        int width = inputImage.getWidth();
        int height = inputImage.getHeight();
        BufferedImage returnImage = new BufferedImage(height, width, inputImage.getType());

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                returnImage.setRGB(height - y - 1, x, inputImage.getRGB(x, y));
//Again check the Picture for better understanding
            }
        }
        return returnImage;
    }

    public static BufferedImage flipVertical(BufferedImage image) {
        AffineTransform tx = AffineTransform.getScaleInstance(1, -1);
        tx.translate(0, -image.getHeight(null));
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
        image = op.filter(image, null);
        return image;
    }

    public static BufferedImage flipHorizontal(BufferedImage image) {
        AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
        tx.translate(-image.getWidth(null), 0);
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
        image = op.filter(image, null);
        return image;
    }

    public static BufferedImage deepCopy(BufferedImage bi) {
        ColorModel cm = bi.getColorModel();
        boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
        WritableRaster raster = bi.copyData(null);
        return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
    }

    //rotate is clockwise
    public static BufferedImage rotateMyImage(BufferedImage img, double angle) {
        int w = img.getWidth();
        int h = img.getHeight();
        BufferedImage dimg = new BufferedImage(w, h, img.getType());
        Graphics2D g = dimg.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, // Anti-alias!
                RenderingHints.VALUE_ANTIALIAS_ON);

        g.rotate(Math.toRadians(angle), w / 2, h / 2);

        g.drawImage(img, null, 0, 0);
        return dimg;
    }
}
