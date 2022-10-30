package uet.oop.bomberman.entities.Animal;

import javafx.scene.image.Image;
import uet.oop.bomberman.control.Move;
import uet.oop.bomberman.graphics.Sprite;

import static uet.oop.bomberman.BombermanGame._height;
import static uet.oop.bomberman.BombermanGame.enemyList;

import java.util.Random;

public class Stupid extends Animal{
    public Stupid(int isMove, int swap, String direction, int count, int countToRun) {
        super(4,1,"right", 0, 0);
    }

    public Stupid() {

    }

    public char direct = 'd';

    public Stupid(int x, int y, Image img) {
        super(x, y, img);
    }

    public void update() {
        //kill();
        //countKill++;
        for(Animal animal : enemyList) {
            if (animal instanceof Balloom && !animal.life) {
                //killBalloom(animal);
            }
        }

        if (this.y % 16 == 0 && this.x % 16 == 0) {
            if (this.y / 32 <= 1) {
                direct = 'd';
            } else if ( this.y / 32 >= _height - 2) {
                direct = 's';
            }

            if (direct == 'd')
                Move.down(this);
            else {
                Move.right(this);
            }
        }
    }
}
