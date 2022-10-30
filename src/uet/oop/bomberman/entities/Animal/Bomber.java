package uet.oop.bomberman.entities.Animal;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import uet.oop.bomberman.graphics.Sprite;

import static uet.oop.bomberman.BombermanGame.*;


public class Bomber extends Animal {
    private static int swapKill = 1;
    public Bomber(int x, int y, Image img) {
        super( x, y, img);
    }

    public Bomber() {

    }

    private void killBomber(Animal animal) {
        if (swapKill == 1) {
            animal.setImg(Sprite.player_dead1.getFxImage());
            swapKill = 2;
        } else if (swapKill == 2) {
            animal.setImg(Sprite.player_dead2.getFxImage());
            swapKill = 3;
        } else if (swapKill == 3) {
            animal.setImg(Sprite.player_dead3.getFxImage());
            swapKill = 4;
        }
    }

    private void checkBomb() {
        if (idObjects[bomberman.getY() / 32][bomberman.getX() / 32] == 'b')
            bomberman.setLife(false);
    }
    private void checkEnemy() {
        int ax = bomberman.getX();
        int ay = bomberman.getY();
        for (Animal animal : enemyList) {
            int bx = animal.getX();
            int by = animal.getY();
            if (ax == bx && by - 32 <= ay && by + 32 >= ay
                    || ay == by && bx - 32 <= ax && bx + 32 >= ax) {
                bomberman.life = false;
                break;
            }
        }
    }
    @Override
    public void update() {
        checkBomb();
        checkEnemy();
        if (!bomberman.life)
            killBomber(bomberman);
    }
}
