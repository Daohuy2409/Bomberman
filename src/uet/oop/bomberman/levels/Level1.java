package uet.oop.bomberman.levels;

import uet.oop.bomberman.entities.Animal.Bomber;
import uet.oop.bomberman.graphics.CreateMap;
import uet.oop.bomberman.graphics.Sprite;

import static uet.oop.bomberman.BombermanGame.*;
import static uet.oop.bomberman.entities.blocks.Bomb.powerBomb;
import static uet.oop.bomberman.entities.item.SpeedItem.speed;

public class Level1 {
    public Level1() {
        enemy.clear();
        block.clear();
        powerBomb = 0;
        new CreateMap("res/levels/Level1.txt");
        speed = 1;


    }

}
