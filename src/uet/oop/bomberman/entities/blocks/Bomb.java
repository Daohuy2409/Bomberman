package uet.oop.bomberman.entities.blocks;

import javafx.scene.image.Image;
import uet.oop.bomberman.control.SoundManager;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.graphics.Sprite;

import static uet.oop.bomberman.BombermanGame.*;


public class Bomb extends Entity {

    private static long timeBomb;
    private static long timeTmp;
    private static Bomb bomb;

    private static Bomb topExplosion;
    private static Bomb downExplosion;
    private static Bomb leftExplosion;
    private static Bomb rightExplosion;

    private static int swapActive = 1;
    private static int swapExplosion = 1;

    private static int swapTop = 1;
    private static int swapDown = 1;
    private static int swapLeft = 1;
    private static int swapRight = 1;

    public static int powerBomb = 0;

    public static int isBomb = 0;   //0 no bomb /1 had bomb /2 explosion

    public Bomb(int x, int y, Image img) {
        super(x, y, img);
    }

    public static void putBomb() {
        if (isBomb == 0) {

            timeBomb = System.currentTimeMillis();
            timeTmp = timeBomb;

            int x = bomberman.getX() / 32;
            int y = bomberman.getY() / 32;
            x = Math.round(x);
            y = Math.round(y);
            bomb = new Bomb(x, y, Sprite.bomb.getFxImage());

            blockList.add(bomb);
            isBomb = 1;
        }
    }
    public static void activeBomb() {
        if (swapActive == 1) {
            bomb.setImg(Sprite.bomb.getFxImage());
            swapActive = 2;
        } else if (swapActive == 2) {
            bomb.setImg(Sprite.bomb_1.getFxImage());
            swapActive = 3;
        } else if (swapActive == 3) {
            bomb.setImg(Sprite.bomb_2.getFxImage());
            swapActive = 4;
        } else {
            bomb.setImg(Sprite.bomb_1.getFxImage());
            swapActive = 1;
        }
    }

    private static void checkActive() {
        if (isBomb == 1) {
            if (System.currentTimeMillis() - timeBomb < 2000) {
                if (System.currentTimeMillis() - timeTmp > 100) {
                    activeBomb();
                    timeTmp += 100;
                }
            } else {
                isBomb = 2;
                timeBomb = System.currentTimeMillis();
                timeTmp = timeBomb;

                topExplosion = new Bomb(bomb.getX() / 32, bomb.getY() / 32 - 1, null);
                downExplosion = new Bomb(bomb.getX() / 32, bomb.getY() / 32 + 1, null);
                leftExplosion = new Bomb(bomb.getX() / 32 - 1, bomb.getY() / 32, null);
                rightExplosion = new Bomb(bomb.getX() / 32 + 1, bomb.getY() / 32, null);

                blockList.add(topExplosion);
                blockList.add(downExplosion);
                blockList.add(leftExplosion);
                blockList.add(rightExplosion);
            }
        }
    }

    private static void createMiddle() {
        if (swapExplosion == 1) {
            bomb.setImg(Sprite.bomb_exploded.getFxImage());
            swapExplosion = 2;
        } else if (swapExplosion == 2) {
            bomb.setImg(Sprite.bomb_exploded1.getFxImage());
            swapExplosion = 3;
        } else if (swapExplosion == 3) {
            bomb.setImg(Sprite.bomb_exploded2.getFxImage());
            swapExplosion = 4;
        } else if (swapExplosion == 4) {
            bomb.setImg(Sprite.bomb_exploded1.getFxImage());
            swapExplosion = 1;
        }

    }
    private static void createTop() {
        if (swapTop == 1) {
            topExplosion.setImg(Sprite.explosion_vertical_top_last.getFxImage());
            swapTop = 2;
        } else if (swapTop == 2) {
            topExplosion.setImg(Sprite.explosion_vertical_top_last1.getFxImage());
            swapTop = 3;
        } else if (swapTop == 3){
            topExplosion.setImg(Sprite.explosion_vertical_top_last2.getFxImage());
            swapTop = 4;
        } else if (swapTop == 4) {
            topExplosion.setImg(Sprite.explosion_vertical_top_last1.getFxImage());
            swapTop = 1;
        }
    }

    private static void createDown() {
        if (swapDown == 1) {
            downExplosion.setImg(Sprite.explosion_vertical_down_last.getFxImage());
            swapDown = 2;
        } else if (swapDown == 2) {
            downExplosion.setImg(Sprite.explosion_vertical_down_last1.getFxImage());
            swapDown = 3;
        } else if (swapDown == 3){
            downExplosion.setImg(Sprite.explosion_vertical_down_last2.getFxImage());
            swapDown = 4;
        } else if (swapDown == 4) {
            downExplosion.setImg(Sprite.explosion_vertical_down_last1.getFxImage());
            swapDown = 1;
        }
    }

    private static void createLeft() {
        if (swapLeft == 1) {
            leftExplosion.setImg(Sprite.explosion_horizontal_left_last.getFxImage());
            swapLeft = 2;
        } else if (swapLeft == 2) {
            leftExplosion.setImg(Sprite.explosion_horizontal_left_last1.getFxImage());
            swapLeft = 3;
        } else if (swapLeft == 3) {
            leftExplosion.setImg(Sprite.explosion_horizontal_left_last2.getFxImage());
            swapLeft = 4;
        } else if (swapLeft == 4) {
            leftExplosion.setImg(Sprite.explosion_horizontal_left_last1.getFxImage());
            swapLeft = 1;
        }
    }

    private static void createRight() {
        if (swapRight == 1) {
            rightExplosion.setImg(Sprite.explosion_horizontal_right_last.getFxImage());
            swapRight = 2;
        } else if (swapRight == 2) {
            rightExplosion.setImg(Sprite.explosion_horizontal_right_last1.getFxImage());
            swapRight = 3;
        } else if (swapRight == 3) {
            rightExplosion.setImg(Sprite.explosion_horizontal_right_last2.getFxImage());
            swapRight = 4;
        } else if (swapRight == 4) {
            rightExplosion.setImg(Sprite.explosion_horizontal_right_last1.getFxImage());
            swapRight = 1;
        }
    }
    private static void checkExplosion() {
        if (isBomb == 2) {


            if (System.currentTimeMillis() - timeBomb < 1000) {
                if (System.currentTimeMillis() - timeTmp > 100) {

                    createMiddle();
                    createTop();
                    createDown();
                    createLeft();
                    createRight();

                    new SoundManager("sound/bomb_explosion.wav", "explosion");
                    timeTmp += 100;
                }
            } else {
                isBomb = 0;
                blockList.remove(bomb);
                blockList.remove(topExplosion);
                blockList.remove(downExplosion);
                blockList.remove(leftExplosion);
                blockList.remove(rightExplosion);
            }
        }
    }

    @Override
    public void update() {
        checkActive();
        checkExplosion();
    }

}
