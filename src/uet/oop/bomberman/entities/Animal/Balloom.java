package uet.oop.bomberman.entities.Animal;

import javafx.scene.image.Image;
import uet.oop.bomberman.control.Move;
import uet.oop.bomberman.graphics.Sprite;

import static uet.oop.bomberman.BombermanGame.enemyList;
import static uet.oop.bomberman.BombermanGame.idObjects;

import java.util.Random;

public class Balloom extends Animal{
    private static long time = System.currentTimeMillis();
    private static long tmp = time;

    public Balloom(int isMove, int swap, String direction, int count, int countToRun) {
        super(4,1,"right", 0, 0);
    }

    public Balloom() {

    }

    @Override
    public void checkBomb() {
        if (idObjects[this.getY() / 32][this.getX() / 32] == 'b')
            this.setLife(false);
    }

    @Override
    public void dead() {
        this.setImg(Sprite.balloom_dead.getFxImage());
        if (System.currentTimeMillis() - time < 2000) {
            if (System.currentTimeMillis() - tmp > 100) {
                tmp += 100;
            }
        } else {
            enemyList.remove(this);
        }
    }

    public Balloom(int x, int y, Image img) {
        super(x, y, img);
    }

    public void update() {
        checkBomb();
        if (!this.isLife()) {
            dead();
        }

        if (this.x % 16 == 0 && this.y % 16 == 0) {
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
