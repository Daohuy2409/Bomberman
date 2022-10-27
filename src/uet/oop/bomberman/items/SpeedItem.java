package uet.oop.bomberman.items;

import javafx.scene.image.Image;
import uet.oop.bomberman.entities.Animal.Bomber;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.graphics.Sprite;

import static uet.oop.bomberman.BombermanGame.block;
import static uet.oop.bomberman.BombermanGame.listKill;
import static uet.oop.bomberman.BombermanGame.bomberman;

public class SpeedItem extends Items {
    public static int speed = 1;

    public SpeedItem(int x, int y, Image img) {
        super(x, y, img);
    }

    public SpeedItem() {
    }

    public SpeedItem(boolean received) {
        super(received);
    }

    @Override
    public void update() {
        for (Entity entity : block)
            if (entity instanceof SpeedItem && !this.received)
                if (listKill[entity.getX() / 32][entity.getY() / 32] == 4)
                    entity.setImg(Sprite.powerup_speed.getFxImage());

        if (!this.received)
            if (bomberman.getX() == this.x && bomberman.getY() == this.y) {
                this.setImg(Sprite.grass.getFxImage());
                this.received = true;
                speed = 2;
            }
    }
}