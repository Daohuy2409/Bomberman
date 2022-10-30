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
    private static Bomb upExplosion;
    private static int swapActive = 1;
    private static int swapExplosion = 1;
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
    private static void createUp() {

    }

    private static void createDown() {

    }

    private static void createLeft() {

    }

    private static void createRight() {

    }
    private static void checkExplosion() {
        if (isBomb == 2) {


            if (System.currentTimeMillis() - timeBomb < 1000) {
                if (System.currentTimeMillis() - timeTmp > 100) {
                    createMiddle();
                    createUp();
                    new SoundManager("sound/bomb_explosion.wav", "explosion");
                    timeTmp += 100;
                }
            } else {
                isBomb = 0;
                blockList.remove(bomb);
            }
        }
    }

    @Override
    public void update() {
        checkActive();
        checkExplosion();
    }

}
