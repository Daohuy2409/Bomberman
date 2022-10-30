package uet.oop.bomberman.graphics;

import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.blocks.*;
import uet.oop.bomberman.entities.item.*;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import static uet.oop.bomberman.BombermanGame.*;

public class CreateMap {
    public CreateMap(String level)  {
        try {
            File file = new File(level);
            Scanner scanner = new Scanner(file);
            if (scanner.hasNextInt()) {
                _level = scanner.nextInt();
                _height = scanner.nextInt();
                _width = scanner.nextInt();
                scanner.nextLine();
            }
            int line = 0;
            idObjects = new char[_height][_width];
            listKill = new char[_height][_width];
            while (scanner.hasNextLine() && line < _height) {
                char[] text = scanner.nextLine().toCharArray();
                if (_width >= 0) System.arraycopy(text, 0, idObjects[line], 0, _width);
                line++;
            }

            for (int i = 0; i < _height; ++i) {
                for (int j = 0; j < _width; j++) {
                    Entity entity;
                    char s = idObjects[i][j];
                    switch (s) {
                        case 'x':
                            entity = new Portal(j, i, Sprite.brick.getFxImage());
                            break;
                        case '#':
                            entity = new Wall(j, i, Sprite.wall.getFxImage());
                            break;
                        case '*':
                            entity = new Brick(j, i, Sprite.brick.getFxImage());
                            break;
                        case 's':
                            entity = new SpeedItem(j, i, Sprite.brick.getFxImage());
                            break;
                        case 'f':
                            entity = new FlameItem(j, i, Sprite.brick.getFxImage());
                            break;
                        default:
                            entity = new Grass(j, i, Sprite.grass.getFxImage());
                    }
                    blockList.add(entity);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
