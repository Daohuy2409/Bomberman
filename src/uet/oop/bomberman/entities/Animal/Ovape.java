package uet.oop.bomberman.entities.Animal;

import javafx.scene.image.Image;
import uet.oop.bomberman.control.Move;
import uet.oop.bomberman.graphics.Sprite;

import java.util.Random;

import static uet.oop.bomberman.BombermanGame.*;

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
            if (this.x / 32 > 1 && this.x / 32 < _width - 2 && this.y /32 > 1 && this.y / 32 < _height - 2 ) {
                Random newRandom = new Random();
                int directionEnemy = newRandom.nextInt(4);
                switch (directionEnemy) {
                    case 0:
                        Move.downAcrossWall(this);
                        break;
                    case 1:
                        Move.upAcrossWall(this);
                        break;
                    case 2:
                        Move.leftAcrossWall(this);
                        break;
                    case 3:
                        Move.rightAcrossWall(this);
                        break;
                }
            }
        }
    }
}
