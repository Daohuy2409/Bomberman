package uet.oop.bomberman;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import uet.oop.bomberman.control.Move;
import uet.oop.bomberman.entities.Animal.Animal;
import uet.oop.bomberman.entities.Animal.Bomber;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.blocks.Bomb;
import uet.oop.bomberman.entities.blocks.Portal;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.levels.Level1;

import java.io.File;
import java.net.MalformedURLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static uet.oop.bomberman.control.SoundManager.updateSound;
import static uet.oop.bomberman.entities.blocks.Portal.isPortal;
import static uet.oop.bomberman.levels.UpLevel.*;

public class BombermanGame extends Application {

    public static final int WIDTH = 31;
    public static final int HEIGHT = 13;

    public static int _width = 0;
    public static int _height = 0;
    public static int _level = 1;
    
    private GraphicsContext gc;
    private Canvas canvas;
    public static final List<Entity> blockList = new ArrayList<>(); //Contains fixed entities
    public static List<Animal> enemyList = new ArrayList<>();       //Contains enemy entities

    public static char[][] idObjects;    //Two-dimensional array is used to test paths
    public static char[][] listKill;     //Array containing dead positions

    public static Animal bomberman;

    public static void main(String[] args) {
        Application.launch(BombermanGame.class);
    }

    @Override
    public void start(Stage stage) {
        // Tao Canvas
        canvas = new Canvas(Sprite.SCALED_SIZE * WIDTH, Sprite.SCALED_SIZE * HEIGHT);
        gc = canvas.getGraphicsContext2D();

        // Tao root container+
        Group root = new Group();
        root.getChildren().add(canvas);

        // Tao scene
        Scene scene = new Scene(root);

        // Them scene vao stage
        stage.setScene(scene);
        stage.setTitle("DoubleH Bomberman");
        stage.show();

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                render();
                update();
            }
        };
        timer.start();


        bomberman = new Bomber(1, 1, Sprite.player_right.getFxImage());
        bomberman.setDirection("right");
        new Level1();
        scene.setOnKeyPressed(event -> {
            if (bomberman.isLife()) {
                switch (event.getCode()) {

                    case UP:
                        Move.up(bomberman);
                        break;
                    case DOWN:
                        Move.down(bomberman);
                        break;
                    case LEFT:
                        Move.left(bomberman);
                        break;
                    case RIGHT:
                        Move.right(bomberman);
                        break;
                    case SPACE:
                        Bomb.putBomb();
                        break;
                }
            } else {
                System.out.println(bomberman.isLife());
            }
        });
    }

    public void update() {

        blockList.forEach(Entity::update);
        enemyList.forEach(Entity::update);

        for (Animal enemy : enemyList) {
            if (idObjects[enemy.getY() / 32][enemy.getX() / 32] == 'b')
                enemy.setLife(false);
            if (!enemy.isLife()) {
                    enemy.dead();
            }
        }

        bomberman.update();

        bomberman.setCountToRun(bomberman.getCountToRun() + 1);
        if (bomberman.getCountToRun() == 4) {
            Move.checkRun(bomberman);
            bomberman.setCountToRun(0);
        }

        for (Animal e : enemyList) {
            e.setCountToRun(e.getCountToRun() + 1);
            if (e.getCountToRun() == 8) {
                Move.checkRun(e);
                e.setCountToRun(0);
            }
        }
        //updateSound();
        if (!isPortal && !isWait) {
            Entity portal = new Portal(2, 3, Sprite.portal.getFxImage());
            blockList.add(portal);
            if (bomberman.getX() / 32 == portal.getX() / 32 && bomberman.getY() / 32 == portal.getY() / 32) {
                isWait = true;
                waitingTime = System.currentTimeMillis();
            }
        }
        waitToLevelUp();
    }

    public void render() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        blockList.forEach(g -> g.render(gc));
        enemyList.forEach(g -> g.render(gc));
        bomberman.render(gc);
    }
}
