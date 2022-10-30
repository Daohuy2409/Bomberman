package uet.oop.bomberman.levels;

import static uet.oop.bomberman.BombermanGame._level;
import static uet.oop.bomberman.entities.blocks.Portal.isPortal;

public class UpLevel {

    public static boolean isWait;

    public static long waitingTime;

    public static void waitToLevelUp() {
        if (isWait) {
            //Image waitToNext = new Image("images/levelUp.png");
            //authorView.setImage(waitToNext);
            long now = System.currentTimeMillis();
            if (now - waitingTime > 3000) {
                switch (_level) {
                    case 1:
                        isPortal = false;
                        new Level2();
                        break;
                    case 2:
                        new Level1();
                }
                isWait = false;
            }
        }
    }
}
