/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package listener;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import setting.ControlSetting;
import snake.Board;
import snake.Direction;
import snake.Snake;

/**
 *
 * @author Quantum
 */
public class SnakeListener extends KeyAdapter {

    private Snake snake;

    public SnakeListener() {
    }

    public SnakeListener(Snake snake) {
        this.snake = snake;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (Board.nextKey) {
            if (key == ControlSetting.getValue(ControlSetting.CS_MOVE_RIGHT) && snake.getDirection() != Direction.D_L) {
                snake.changeDirection(Direction.D_R);
            } else if (key == ControlSetting.getValue(ControlSetting.CS_MOVE_DOWN)&& snake.getDirection() != Direction.D_U) {
                snake.changeDirection(Direction.D_D);
            } else if (key == ControlSetting.getValue(ControlSetting.CS_MOVE_LEFT) && snake.getDirection() != Direction.D_R) {
                snake.changeDirection(Direction.D_L);
            } else if (key == ControlSetting.getValue(ControlSetting.CS_MOVE_UP)&& snake.getDirection() != Direction.D_D) {
                snake.changeDirection(Direction.D_U);
            }
            Board.nextKey = false;
        }
        if (key == ControlSetting.getValue(ControlSetting.CS_PAUSE)) {
            if (Board.pause) {
                Board.pause = false;
            } else {
                Board.pause = true;
            }
        }
    }
}
