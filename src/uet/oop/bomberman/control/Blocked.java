package uet.oop.bomberman.control;


import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.graphics.Sprite;

import static uet.oop.bomberman.BombermanGame.*;

public class Blocked {

    public static boolean block_down(Entity entity) {

        return idObjects[entity.getY() / 32 + 1][entity.getX() / 32] == ' '
                || idObjects[entity.getY() / 32 + 1][entity.getX() / 32] == 'b';
    }

    public static boolean block_up(Entity entity) {
        return idObjects[entity.getY() / 32 - 1][entity.getX() / 32] == ' '
                || idObjects[entity.getY() / 32 - 1][entity.getX() / 32] == 'b';
    }

    public static boolean block_left(Entity entity) {
        return idObjects[entity.getY() / 32][entity.getX() / 32 - 1] == ' '
                || idObjects[entity.getY() / 32][entity.getX() / 32 - 1] == 'b';
    }

    public static boolean block_right(Entity entity) {
        return idObjects[entity.getY() / 32][entity.getX() / 32 + 1] == ' '
                || idObjects[entity.getY() / 32][entity.getX() / 32 + 1] == 'b';

    }

    public static boolean block_down_bomb(Entity entity, int power) {
        return idObjects[entity.getY() / 32 + 1 + power][entity.getX() / 32] == ' '
                || idObjects[entity.getY() / 32 + 1 + power][entity.getX() / 32] == '*';
    }

    public static boolean block_up_bomb(Entity entity, int power) {
        return idObjects[entity.getY() / 32 - 1 - power][entity.getX() / 32] == ' '
                || idObjects[entity.getY() / 32 - 1 - power][entity.getX() / 32] == '*';
    }

    public static boolean block_left_bomb(Entity entity, int power) {
        return idObjects[entity.getY() / 32][entity.getX() / 32 - 1 - power] == ' '
                || idObjects[entity.getY() / 32][entity.getX() / 32 - 1 - power] == '*';
    }

    public static boolean block_right_bomb(Entity entity, int power) {
        return idObjects[entity.getY() / 32][entity.getX() / 32 + 1 + power] == ' '
                || idObjects[entity.getY() / 32][entity.getX() / 32 + 1 + power] == '*';
    }
}