package uet.oop.bomberman.entities.Animal;

import java.lang.Math;

import javafx.scene.image.Image;
import uet.oop.bomberman.control.Move;
import uet.oop.bomberman.graphics.Sprite;

import java.util.Random;

import static uet.oop.bomberman.BombermanGame.*;

public class Oneal extends Animal{

    private static long time = System.currentTimeMillis();
    private static long tmp = time;
    public Oneal(int isMove, int swap, String direction, int count, int countToRun) {
        super(4,1,"left", 0, 0);
    }

    public Oneal() {

    }

    @Override
    public void checkBomb() {
        if (idObjects[this.getY() / 32][this.getX() / 32] == 'b')
            this.setLife(false);
    }

    @Override
    public void dead() {
        this.setImg(Sprite.oneal_dead.getFxImage());
        if (System.currentTimeMillis() - time < 1000) {
            if (System.currentTimeMillis() - tmp > 100) {
                tmp += 100;
            }
        } else {
            enemyList.remove(this);
        }

    }

    public Oneal(int x, int y, Image img) {
        super(x, y, img);
    }

    public void update() {
        checkBomb();
        if (!this.isLife()) {
            dead();
        }
        if (this.x % 16 == 0 && this.y % 16 == 0) {
            if ((Math.abs(bomberman.getX() - this.x) < 400) && (Math.abs(bomberman.getY() - this.y) < 200)) {
                if (bomberman.getX() < this.x) {
                    Move.left(this);
                }
                if (bomberman.getX() > this.x) {
                    Move.right(this);
                }
                if (bomberman.getY() > this.y) {
                    Move.down(this);
                }
                if (bomberman.getY() < this.y) {
                    Move.up(this);
                }
            } else {
                Random newRandom = new Random();
                int directionEnemy = newRandom.nextInt(4);
                switch (directionEnemy) {
                    case 0:
                        Move.down(this);
                        break;
                    case 1:
                        Move.up(this);
                        break;
                    case 2:
                        Move.left(this);
                        break;
                    case 3:
                        Move.right(this);
                        break;
                }
            }
        }
    }
}
