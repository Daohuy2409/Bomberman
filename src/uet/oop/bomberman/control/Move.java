package uet.oop.bomberman.control;

import com.sun.corba.se.spi.oa.OADestroyed;
import uet.oop.bomberman.entities.Animal.*;
import uet.oop.bomberman.graphics.Sprite;


import static uet.oop.bomberman.entities.item.SpeedItem.speed;

public class Move {

    public static void checkRun(Animal animal) {
        if (animal instanceof Bomber && animal.getCount() > 0) {
            setDirection(animal.getDirection(), animal, 8 * speed);
            animal.setCount(animal.getCount() - 1);
        }
        if ((animal instanceof Balloom || animal instanceof Oneal
                || animal instanceof Stupid || animal instanceof Ovape)
                && animal.getCount() > 0) {
            setDirection(animal.getDirection(), animal, 4);
            animal.setCount(animal.getCount() - 1);
        }
    }

    private static void setDirection(String direction, Animal animal, int isMove) {
        if (animal instanceof Ovape) {
            switch (direction) {
                case "down":
                    down_stepAcrossWall(animal);
                    animal.setY(animal.getY() + isMove);
                    break;
                case "up":
                    up_stepAcrossWall(animal);
                    animal.setY(animal.getY() - isMove);
                    break;
                case "left":
                    left_stepAcrossWall(animal);
                    animal.setX(animal.getX() - isMove);
                    break;
                case "right":
                    right_stepAcrossWall(animal);
                    animal.setX(animal.getX() + isMove);
                    break;
            }
        }
        else {
            switch (direction) {
                case "down":
                    down_step(animal);
                    animal.setY(animal.getY() + isMove);
                    break;
                case "up":
                    up_step(animal);
                    animal.setY(animal.getY() - isMove);
                    break;
                case "left":
                    left_step(animal);
                    animal.setX(animal.getX() - isMove);
                    break;
                case "right":
                    right_step(animal);
                    animal.setX(animal.getX() + isMove);
                    break;
            }
        }

    }

    public static void down(Animal animal) {
        if (animal.getY() % 32 == 0 && animal.getX() % 32 == 0) {
            if (animal instanceof Bomber && Blocked.block_down(animal)) {
                animal.setDirection("down");
                animal.setCount(4 / speed);
                checkRun(animal);
            }
            if ((animal instanceof Balloom || animal instanceof Oneal
                    || animal instanceof Stupid || animal instanceof Ovape)
                    && Blocked.block_down(animal)) {
                animal.setDirection("down");
                animal.setCount(8);
                checkRun(animal);
            }
        }
    }

    private static void down_step(Animal animal) {
        if (animal instanceof Bomber && animal.getY() % 8 == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.player_down.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.player_down_1.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.player_down.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.player_down_2.getFxImage());
                animal.setSwap(1);
            }
        }
        if (animal instanceof Balloom && animal.getY() % 8 == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.balloom_right1.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.balloom_right2.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.balloom_right3.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.balloom_right2.getFxImage());
                animal.setSwap(1);
            }
        }
        if (animal instanceof Oneal && animal.getY() % 8 == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.oneal_right1.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.oneal_right2.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.oneal_right3.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.oneal_right2.getFxImage());
                animal.setSwap(1);
            }
        }
        if (animal instanceof Stupid && animal.getY() % 8 == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.kondoria_right1.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.kondoria_right2.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.kondoria_right3.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.kondoria_right2.getFxImage());
                animal.setSwap(1);
            }
        }
    }

    public static void up(Animal animal) {
        if (animal.getY() % 32 == 0 && animal.getX() % 32 == 0) {
            if (animal instanceof Bomber && Blocked.block_up(animal)
                    || animal instanceof Stupid || animal instanceof Ovape) {
                animal.setDirection("up");
                animal.setCount(4 / speed);
                checkRun(animal);
            }
            if ((animal instanceof Balloom || animal instanceof Oneal)
                    && Blocked.block_up(animal)) {
                animal.setDirection("up");
                animal.setCount(8);
                checkRun(animal);
            }
        }
    }

    private static void up_step(Animal animal) {
        if (animal instanceof Bomber && animal.getY() % 8 == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.player_up.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.player_up_1.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.player_up.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.player_up_2.getFxImage());
                animal.setSwap(1);
            }
        }
        if (animal instanceof Balloom && animal.getY() % 8 == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.balloom_left1.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.balloom_left2.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.balloom_left3.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.balloom_left2.getFxImage());
                animal.setSwap(1);
            }
        }
        if (animal instanceof Oneal && animal.getY() % 8 == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.oneal_left1.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.oneal_left2.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.oneal_left3.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.oneal_left2.getFxImage());
                animal.setSwap(1);
            }
        }
        if (animal instanceof Stupid && animal.getY() % 8 == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.kondoria_left1.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.kondoria_left2.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.kondoria_left3.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.kondoria_left2.getFxImage());
                animal.setSwap(1);
            }
        }
    }

    public static void left(Animal animal) {
        if (animal.getX() % 32 == 0 && animal.getY() % 32 == 0) {
            if (animal instanceof Bomber && Blocked.block_left(animal)) {
                animal.setDirection("left");
                animal.setCount(4 / speed);
                checkRun(animal);
            }
            if ((animal instanceof Balloom || animal instanceof Oneal
                    || animal instanceof Stupid || animal instanceof Ovape)
                    && Blocked.block_left(animal)) {
                animal.setDirection("left");
                animal.setCount(8);
                checkRun(animal);
            }
        }
    }

    private static void left_step(Animal animal) {
        if (animal instanceof Bomber && animal.getX() % 8 == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.player_left.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.player_left_1.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.player_left.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.player_left_2.getFxImage());
                animal.setSwap(1);
            }
        }
        if (animal instanceof Balloom && animal.getY() % 8 == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.balloom_right1.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.balloom_right2.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.balloom_right3.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.balloom_right2.getFxImage());
                animal.setSwap(1);
            }
        }
        if (animal instanceof Oneal && animal.getY() % 8 == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.oneal_right1.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.oneal_right2.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.oneal_right3.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.oneal_right2.getFxImage());
                animal.setSwap(1);
            }
        }
    }

    public static void right(Animal animal) {
        if (animal.getX() % 32 == 0 && animal.getY() % 32 == 0) {
            if (animal instanceof Bomber && Blocked.block_right(animal)) {
                animal.setDirection("right");
                animal.setCount(4 / speed);
                checkRun(animal);
            }
            if ((animal instanceof Balloom || animal instanceof Oneal
                    || animal instanceof Stupid || animal instanceof Ovape)
                    && Blocked.block_right(animal)) {
                animal.setDirection("right");
                animal.setCount(8);
                checkRun(animal);
            }
        }
    }

    public static void right_step(Animal animal) {
        if (animal instanceof Bomber && animal.getX() % 8 == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.player_right.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.player_right_1.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.player_right.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.player_right_2.getFxImage());
                animal.setSwap(1);
            }
        }

        if (animal instanceof Balloom && animal.getY() % 8 == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.balloom_left1.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.balloom_left2.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.balloom_left3.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.balloom_left2.getFxImage());
                animal.setSwap(1);
            }
        }
        if (animal instanceof Oneal && animal.getY() % 8 == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.oneal_left1.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.oneal_left2.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.oneal_left3.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.oneal_left2.getFxImage());
                animal.setSwap(1);
            }
        }
        if (animal instanceof Stupid && animal.getY() % 8 == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.kondoria_right1.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.kondoria_right2.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.kondoria_right3.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.kondoria_right2.getFxImage());
                animal.setSwap(1);
            }
        }
    }



    public static void downAcrossWall(Animal animal) {
        if (animal.getY() % 32 == 0 && animal.getX() % 32 == 0) {
            if (animal instanceof Ovape) {
                animal.setDirection("down");
                animal.setCount(8);
                checkRun(animal);
            }
        }
    }

    private static void down_stepAcrossWall(Animal animal) {
        if (animal instanceof Ovape && animal.getY() % 8 == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.doll_left1.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.doll_left2.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.doll_left3.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.doll_left2.getFxImage());
                animal.setSwap(1);
            }
        }
    }

    public static void upAcrossWall(Animal animal) {
        if (animal.getY() % 32 == 0 && animal.getX() % 32 == 0) {
            if (animal instanceof Ovape) {
                animal.setDirection("up");
                animal.setCount(8);
                checkRun(animal);
            }
        }
    }

    private static void up_stepAcrossWall(Animal animal) {
        if (animal instanceof Ovape && animal.getY() % 8 == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.doll_right1.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.doll_right2.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.doll_right3.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.doll_right2.getFxImage());
                animal.setSwap(1);
            }
        }
    }

    public static void leftAcrossWall(Animal animal) {
        if (animal.getX() % 32 == 0 && animal.getY() % 32 == 0) {
            if (animal instanceof Ovape) {
                animal.setDirection("left");
                animal.setCount(8);
                checkRun(animal);
            }
        }
    }

    private static void left_stepAcrossWall(Animal animal) {
        if (animal instanceof Ovape && animal.getY() % 8 == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.doll_left1.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.doll_left2.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.doll_left3.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.doll_left2.getFxImage());
                animal.setSwap(1);
            }
        }
    }

    public static void rightAcrossWall(Animal animal) {
        if (animal.getX() % 32 == 0 && animal.getY() % 32 == 0) {
            if (animal instanceof Ovape) {
                animal.setDirection("right");
                animal.setCount(8);
                checkRun(animal);
            }
        }
    }

    public static void right_stepAcrossWall(Animal animal) {
        if (animal instanceof Ovape && animal.getY() % 8 == 0) {
            if (animal.getSwap() == 1) {
                animal.setImg(Sprite.doll_right1.getFxImage());
                animal.setSwap(2);
            } else if (animal.getSwap() == 2) {
                animal.setImg(Sprite.doll_right2.getFxImage());
                animal.setSwap(3);
            } else if (animal.getSwap() == 3) {
                animal.setImg(Sprite.doll_right3.getFxImage());
                animal.setSwap(4);
            } else {
                animal.setImg(Sprite.doll_right2.getFxImage());
                animal.setSwap(1);
            }
        }
    }
}
