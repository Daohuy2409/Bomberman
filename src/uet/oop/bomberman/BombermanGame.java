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
import uet.oop.bomberman.entities.blocks.Brick;
import uet.oop.bomberman.entities.blocks.Grass;
import uet.oop.bomberman.entities.blocks.Wall;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.levels.Level1;

import java.util.ArrayList;
import java.util.List;

import static uet.oop.bomberman.control.SoundManager.updateSound;
<<<<<<< Updated upstream
import static uet.oop.bomberman.graphics.MapLevel.setMapArr;
import static uet.oop.bomberman.graphics.MapLevel.mapArr;
import static uet.oop.bomberman.graphics.MapLevel.rows;
import static uet.oop.bomberman.graphics.MapLevel.cols;
=======
>>>>>>> Stashed changes
public class BombermanGame extends Application {

    public static final int WIDTH = 31;
    public static final int HEIGHT = 13;

    public static int _width = 0;
    public static int _height = 0;
    public static int _level = 1;
    private GraphicsContext gc;
    private Canvas canvas;
    public static List<Animal> enemy = new ArrayList<>();
    public static final List<Entity> block = new ArrayList<>();

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

        createMap();
        bomberman = new Bomber(1, 1, Sprite.player_right.getFxImage());
        enemy.add(bomberman);
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

    public void createMap() {
<<<<<<< Updated upstream
        setMapArr();
        for (int i = 0; i < WIDTH; i++) {
                for (int j = 0; j < HEIGHT; j++) {
                    Entity object;
                    if (mapArr[j][i] == '#') {
                        object = new Wall(i, j, Sprite.wall.getFxImage());
                    } else if(mapArr[j][i] == '*') {
                        object = new Brick(i, j, Sprite.brick.getFxImage());
                    } else{
                        object = new Grass(i, j, Sprite.grass.getFxImage());
                    }
                    stillObjects.add(object);
                }
            }

=======
        new Level1();
>>>>>>> Stashed changes
    }

    public void update() {

        enemy.forEach(Entity::update);
        //bomberman.update();
        //updateSound();
    }

    public void render() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        block.forEach(g -> g.render(gc));
        enemy.forEach(g -> g.render(gc));
    }
}
