package uet.oop.bomberman.entities.blocks;

import javafx.scene.image.Image;
import uet.oop.bomberman.entities.Entity;

import java.util.ArrayList;
import java.util.List;

public class Bomb extends Entity {
    public static int powerBomb = 0;

    public Bomb(int x, int y, Image img) {
        super(x, y, img);
    }

    @Override
    public void update() {

    }

}
