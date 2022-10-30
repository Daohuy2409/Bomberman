package uet.oop.bomberman.entities.Animal;

import javafx.scene.image.Image;
import uet.oop.bomberman.control.Move;
import uet.oop.bomberman.graphics.Sprite;

import java.util.Random;

import static uet.oop.bomberman.BombermanGame.*;

public class Stupid extends Animal{
    private static long time = System.currentTimeMillis();
    private static long tmp = time;

    public Stupid(int isMove, int swap, String direction, int count, int countToRun) {
        super(4,1,"left", 0, 0);
    }

    public Stupid() {

    }

    @Override
    public void checkBomb() {
        if (idObjects[this.getY() / 32][this.getX() / 32] == 'b')
            this.setLife(false);
    }

    @Override
    public void dead() {
        this.setImg(Sprite.kondoria_dead.getFxImage());
        if (System.currentTimeMillis() - time < 1000) {
            if (System.currentTimeMillis() - tmp > 100) {
                tmp += 100;
            }
        } else {
            enemyList.remove(this);
        }
    }

    private static char direct = 'r';

    public Stupid(int x, int y, Image img) {
        super(x, y, img);
    }


    public void update() {

        checkBomb();
        if (!this.isLife()) {
            dead();
        }

        if (this.y % 16 == 0 && this.x % 16 == 0) {
            if (this.x / 32 <= 1) {
                direct = 'r';
            } else if (this.x / 32 >= _width - 2){
                direct = 'd';
            }

            if (direct == 'r') {
                Move.right(this);
            } else {
                Move.left(this);
            }
        }
    }
}
