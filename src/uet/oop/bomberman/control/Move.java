package uet.oop.bomberman.control;

import uet.oop.bomberman.entities.Bomber;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.graphics.Sprite;

public class Move {
    public static int countUp = 0;
    public static int countDown = 0;
    public static int countLeft = 0;
    public static int countRight = 0;
    public void up(Entity entity) {
        if (entity instanceof Bomber) {
            //dem so buoc
            countUp++;
            countDown = 0;
            countLeft = 0;
            countRight = 0;

            if (countUp > 3) {
                countUp = 1;
            }
            if (countUp == 1){
                entity.setImg(Sprite.player_up.getFxImage());
            } else if (countUp == 2) {
                entity.setImg(Sprite.player_up_1.getFxImage());
            } else if(countUp == 3){
                entity.setImg(Sprite.player_up_2.getFxImage());
            }
            entity.setY(entity.getY() - 3);
        }
    }

    public void down(Entity entity) {
        if (entity instanceof Bomber) {
            //dem so buoc
            countUp = 0;
            countDown++;
            countLeft = 0;
            countRight = 0;

            if (countDown > 3) {
                countDown = 1;
            }
            if (countDown == 1){
                entity.setImg(Sprite.player_down.getFxImage());
            } else if (countDown == 2) {
                entity.setImg(Sprite.player_down_1.getFxImage());
            } else if(countDown == 3){
                entity.setImg(Sprite.player_down_2.getFxImage());
            }
            entity.setY(entity.getY() + 3);
        }
    }

    public void left(Entity entity) {
        if (entity instanceof Bomber) {
            //dem so buoc
            countUp = 0;
            countDown = 0;
            countLeft++;
            countRight = 0;

            if (countLeft > 3) {
                countLeft = 1;
            }
            if (countLeft == 1){
                entity.setImg(Sprite.player_left.getFxImage());
            } else if (countLeft == 2) {
                entity.setImg(Sprite.player_left_1.getFxImage());
            } else if(countLeft == 3){
                entity.setImg(Sprite.player_left_2.getFxImage());
            }
            entity.setX(entity.getX() - 3);
        }
    }

    public void right(Entity entity) {
        if (entity instanceof Bomber) {
            //dem so buoc
            countUp = 0;
            countDown = 0;
            countLeft = 0;
            countRight++;

            if (countRight > 3) {
                countRight = 1;
            }
            if (countRight == 1){
                entity.setImg(Sprite.player_right.getFxImage());
            } else if (countRight == 2) {
                entity.setImg(Sprite.player_right_1.getFxImage());
            } else if(countRight == 3){
                entity.setImg(Sprite.player_right_2.getFxImage());
            }
            entity.setX(entity.getX() + 3);
        }
    }
}
