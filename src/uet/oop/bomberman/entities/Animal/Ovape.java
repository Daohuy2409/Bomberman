package uet.oop.bomberman.entities.Animal;

import javafx.scene.image.Image;
import uet.oop.bomberman.control.Move;
import uet.oop.bomberman.graphics.Sprite;

import static uet.oop.bomberman.BombermanGame.enemyList;

import java.util.Random;

public class Ovape extends Animal{
    public Ovape(int isMove, int swap, String direction, int count, int countToRun) {
        super(4,1,"right", 0, 0);
    }

    public Ovape() {

    }

    public Ovape(int x, int y, Image img) {
        super(x, y, img);
    }

    public void update() {
        //kill();
        //countKill++;
        for(Animal animal : enemyList) {
            if (animal instanceof Ovape && !animal.life) {
                //killOvape(animal);
            }
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
