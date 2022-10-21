package uet.oop.bomberman.control;

import uet.oop.bomberman.entities.Bomber;
import uet.oop.bomberman.entities.Entity;

public class Move {
    public void up(Entity entity) {
        if (entity instanceof Bomber) {
            entity.setY(entity.getY() - 3);
        }
    }

    public void down(Entity entity) {
        if (entity instanceof Bomber) {
            entity.setY(entity.getY() + 3);
        }
    }

    public void left(Entity entity) {
        if (entity instanceof Bomber) {
            entity.setX(entity.getX() - 3);
        }
    }

    public void right(Entity entity) {
        if (entity instanceof Bomber) {
            entity.setX(entity.getX() + 3);
        }
    }
}
