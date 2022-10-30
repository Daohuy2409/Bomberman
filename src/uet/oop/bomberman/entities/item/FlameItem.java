package uet.oop.bomberman.entities.item;

import javafx.scene.image.Image;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.blocks.Bomb;
import uet.oop.bomberman.graphics.Sprite;

import static uet.oop.bomberman.BombermanGame.*;

public class FlameItem extends Item {
    public FlameItem(int x, int y, Image img) {
        super(x, y, img);
    }

    public FlameItem(boolean received) {
        super(received);
    }

    public FlameItem() {
    }

    @Override
    public void update() {
        if (!this.received)
            if (bomberman.getX() == this.x && bomberman.getY() == this.y) {
                this.setImg(Sprite.grass.getFxImage());
                this.received = true;
                //Bomb.powerBomb += 2;
            }
    }
}
