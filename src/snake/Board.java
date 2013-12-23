/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import renderer.FoodD;
import renderer.ImageResources;
import renderer.ObstacleD;
import renderer.SnakeD;
import food.util.FoodContainer;
import grid.ObstacleContainer;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import listener.SnakeListener;
import map.Map;
import player.Player;
import setting.ControlSetting;
import user.User;

/**
 *
 * @author Quantum
 */
public class Board extends Canvas implements ActionListener {

    public static final String VERSION = "v1.3_Beta01";
    public static Map map;
    public static Player player;
    public static boolean nextKey;
    public static int delay = 100;//default=100
    public static int maxX;
    public static int maxY;
    public static boolean pause = false;
    public static User user=new User();
    public SnakeListener listener;
    private final int TILE_SIZE = 16;
    private Timer timer;
    private Snake snake;
    private FoodContainer foodContainer;
    private ObstacleContainer obstacleContainer;
    private Image snakeBoard;
    private Image scoreBoard;
    private int startX;
    private int startY;
    private int lastGrid;
    
    public Board() {
        load();
        startX = 0;
        startY = 16;
        snake = new Snake();
        listener = new SnakeListener(snake);
        player = new Player();
        setFocusable(false);
        Setting.foodLimit = 10;
        this.addKeyListener(listener);
    }

    private void load() {
        try {
            ImageResources.LoadImage();
        } catch (IOException ex) {
            System.out.println(ex);
        }
        ControlSetting.load();
    }

    public void settingGame(int xTile, int yTile, int length, int foodLimit) {
        Setting.snakeLength = length;
        maxX = xTile;
        maxY = yTile;
        Setting.foodLimit = foodLimit;
        snakeBoard = new BufferedImage((maxX + 1) * TILE_SIZE, (maxY + 1) * TILE_SIZE, BufferedImage.TYPE_INT_RGB);
        scoreBoard = new BufferedImage((maxX + 1) * TILE_SIZE, 16, BufferedImage.TYPE_INT_RGB);
    }

    public void startGame(int gridType) {
        resetGame();
        lastGrid = gridType;
        snake.init(Setting.snakeLength);
        obstacleContainer.buildGrid(gridType);
        obstacleContainer.start();
        foodContainer.start();
        timer.start();
        this.setSize((maxX + 1) * TILE_SIZE, (maxY + 2) * TILE_SIZE);
    }

    public void resetGame() {
        snake.reset();
        player.reset();
        timer = new Timer(delay, this);
        map = new Map();
        foodContainer = new FoodContainer(Setting.foodLimit, snake);
        obstacleContainer = new ObstacleContainer();
        map.addUnit(snake);
        pause=false;
    }

    public void stopGame() {
        if (timer != null) {
            timer.stop();
        }
        if (obstacleContainer != null) {
            obstacleContainer = null;
        }
        if (foodContainer != null) {
            foodContainer.shutDown();
        }
    }

    public Snake getSnake() {
        return snake;
    }

    public void drawSnake(Graphics g) {
        for (int i = 0; i < snake.body.size(); i++) {
            SnakeD.drawSnakeImage(g, snake.body.get(i)[0], snake.body.get(i)[1], snake.body.get(i)[2], TILE_SIZE);
        }
    }

    public void drawFood(Graphics g) {
        for (int i = 0; i < foodContainer.size(); i++) {
            FoodD.drawFood(g, foodContainer.get(i), TILE_SIZE);
        }
    }

    public void drawObstacle(Graphics g) {
        for (int i = 0; i < obstacleContainer.size(); i++) {
            ObstacleD.drawObstacle(g, obstacleContainer.get(i), TILE_SIZE);
        }
    }

    @Override
    public void paint(Graphics g) {
        update(g);
    }

    @Override
    public void update(Graphics g) {
        g.drawImage(snakeBoard, startX, startY, null);
        g.drawImage(scoreBoard, 0, 0, null);
        //g.drawImage(scoreBoard,10,10,null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!pause) {
            if (ImageResources.stated) {
                ImageResources.stated = false;
            } else {
                ImageResources.stated = true;
            }
            foodContainer.eatHandling(foodContainer.getEaten());
            snake.move();
            fillImage();
            repaint();
            if (snake.isDeath()) {
                stopGame();
                int choose = JOptionPane.showConfirmDialog(this, "Game Over \nScore : " + Integer.toString(player.getValue()), "Restart Game?", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE, new ImageIcon(ImageResources.I_R_DIE_SNAKE));
                if (choose == JOptionPane.YES_OPTION) {
                    this.startGame(lastGrid);
                }
            }
            nextKey = true;
        } else {
            Graphics g = scoreBoard.getGraphics();
            g.drawImage(new PauseSplash(), (maxX-1)*TILE_SIZE/2,1, null);
            repaint();
        }
    }

    public void fillImage() {
        //belong to snakeBoard
        Graphics g1 = snakeBoard.getGraphics();
        g1.fillRect(0, 0, (maxX + 1) * TILE_SIZE, (maxY + 1) * TILE_SIZE);
        drawFood(snakeBoard.getGraphics());
        drawSnake(snakeBoard.getGraphics());
        drawObstacle(snakeBoard.getGraphics());
        g1.setColor(new Color(0, 0, 0));
        int[] x = {0, 0, (maxX + 1) * TILE_SIZE - 1, (maxX + 1) * TILE_SIZE - 1};
        int[] y = {0, (maxY + 1) * TILE_SIZE - 1, (maxY + 1) * TILE_SIZE - 1, 0};
        g1.drawPolygon(x, y, x.length);
        //belong to scoreBoard
        Graphics g = scoreBoard.getGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, scoreBoard.getWidth(null), scoreBoard.getHeight(null));
        g.setColor(Color.BLACK);
        g.drawString("Score: " + player.getValue(), 0, 12);
        g.drawImage(snake.health, 100, 0, null);
    }
}
