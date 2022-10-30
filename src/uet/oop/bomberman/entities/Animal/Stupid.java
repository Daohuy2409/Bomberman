package uet.oop.bomberman.entities.Animal;

import javafx.scene.image.Image;
import uet.oop.bomberman.control.Move;
import uet.oop.bomberman.graphics.Sprite;

import static uet.oop.bomberman.BombermanGame._width;
import static uet.oop.bomberman.BombermanGame.enemyList;

import java.util.Random;

public class Stupid extends Animal{
    public Stupid(int isMove, int swap, String direction, int count, int countToRun) {
        super(4,1,"left", 0, 0);
    }

    public Stupid() {

    }
    private static char direct = 'r';

    public Stupid(int x, int y, Image img) {
        super(x, y, img);
    }


    public void update() {

        for(Animal animal : enemyList) {
            if (animal instanceof Balloom && !animal.life) {
                //killBalloom(animal);
            }
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
