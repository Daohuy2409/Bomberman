package uet.oop.bomberman.levels;

import uet.oop.bomberman.entities.Animal.*;
import uet.oop.bomberman.graphics.CreateMap;
import uet.oop.bomberman.graphics.Sprite;
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


        Animal stupid1 = new Stupid(3, 9, Sprite.kondoria_left1.getFxImage());
        Animal ovape1 = new Ovape(23, 7, Sprite.doll_left1.getFxImage());
        enemyList.add(stupid1);
        enemyList.add(ovape1);

        Animal oneal1 = new Oneal(26, 6, Sprite.oneal_left1.getFxImage());
        Animal oneal2 = new Oneal(20, 3, Sprite.oneal_left1.getFxImage());
        enemyList.add(oneal1);
        enemyList.add(oneal2);
    }

}
