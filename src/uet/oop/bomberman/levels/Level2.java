package uet.oop.bomberman.levels;

import uet.oop.bomberman.entities.Animal.Bomber;
import uet.oop.bomberman.graphics.CreateMap;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.entities.Animal.Balloom;
import uet.oop.bomberman.entities.Animal.Oneal;
import uet.oop.bomberman.entities.Animal.Animal;
import javafx.scene.image.Image;

import static uet.oop.bomberman.BombermanGame.*;
import static uet.oop.bomberman.entities.blocks.Bomb.powerBomb;
import static uet.oop.bomberman.entities.item.SpeedItem.speed;

public class Level2 {
    public Level2() {
        enemyList.clear();
        blockList.clear();
        powerBomb = 0;
        new CreateMap("res/levels/Level2.txt");
        speed = 1;

        Animal balloom1 = new Balloom(4, 9, Sprite.balloom_left1.getFxImage());
        Animal balloom2 = new Balloom(23, 7, Sprite.balloom_left1.getFxImage());
        enemyList.add(balloom1);
        enemyList.add(balloom2);

        Animal oneal1 = new Oneal(26, 6, Sprite.oneal_left1.getFxImage());
        Animal oneal2 = new Oneal(20, 3, Sprite.oneal_left1.getFxImage());
        enemyList.add(oneal1);
        enemyList.add(oneal2);
    }

}
