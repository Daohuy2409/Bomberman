package uet.oop.bomberman.entities.Animal;

import java.lang.Math;

import javafx.scene.image.Image;
import uet.oop.bomberman.control.Move;
import uet.oop.bomberman.graphics.Sprite;

import static uet.oop.bomberman.BombermanGame.bomberman;
import static uet.oop.bomberman.BombermanGame.enemyList;

import java.util.Random;

public class Oneal extends Animal{
    public Oneal(int isMove, int swap, String direction, int count, int countToRun) {
        super(4,1,"left", 0, 0);
    }

    public Oneal() {

    }

    public Oneal(int x, int y, Image img) {
        super(x, y, img);
    }

    public void update() {
        //kill();
        //countKill++;
        for(Animal animal : enemyList) {
            if (animal instanceof Oneal && !animal.life) {
                //killOneal(animal);
            }
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
