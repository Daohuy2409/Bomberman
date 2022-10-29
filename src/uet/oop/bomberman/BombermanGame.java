package uet.oop.bomberman;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

import uet.oop.bomberman.control.Move;
import uet.oop.bomberman.entities.Animal.Animal;
import uet.oop.bomberman.entities.Animal.Bomber;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.levels.Level1;

import java.util.ArrayList;
import java.util.List;

import static uet.oop.bomberman.control.SoundManager.updateSound;
public class BombermanGame extends Application {

    public static final int WIDTH = 31;
    public static final int HEIGHT = 13;

    public static int _width = 0;
    public static int _height = 0;
    public static int _level = 1;
    
    private GraphicsContext gc;
    private Canvas canvas;
    public static final List<Entity> block = new ArrayList<>(); //Contains fixed entities
    public static List<Animal> enemy = new ArrayList<>();       //Contains enemy entities

    public static char[][] idObjects;    //Two-dimensional array is used to test paths
    public static int[][] listKill;     //Array containing dead positions

    public static Animal bomberman;

    public static void main(String[] args) {
        Application.launch(BombermanGame.class);
    }

    @Override
    public void start(Stage stage) {
        // Tao Canvas
        canvas = new Canvas(Sprite.SCALED_SIZE * WIDTH, Sprite.SCALED_SIZE * HEIGHT);
        gc = canvas.getGraphicsContext2D();

        // Tao root container
        Group root = new Group();
        root.getChildren().add(canvas);

        // Tao scene
        Scene scene = new Scene(root);



        // Them scene vao stage
        stage.setScene(scene);
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
                        System.out.println("space");
                        break;
                }
            }
        });
    }

    public void update() {

        enemy.forEach(Entity::update);
        enemy.forEach(Entity::update);
        bomberman.update();
        bomberman.setCountToRun(bomberman.getCountToRun() + 1);
        if (bomberman.getCountToRun() == 4) {
            Move.checkRun(bomberman);
            bomberman.setCountToRun(0);
        }
        //updateSound();
    }

    public void render() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        block.forEach(g -> g.render(gc));
        enemy.forEach(g -> g.render(gc));
        bomberman.render(gc);
    }
}
