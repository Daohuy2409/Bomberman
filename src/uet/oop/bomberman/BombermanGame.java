package uet.oop.bomberman;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

import uet.oop.bomberman.control.Move;
import uet.oop.bomberman.entities.Animal.Bomber;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.blocks.Brick;
import uet.oop.bomberman.entities.blocks.Grass;
import uet.oop.bomberman.entities.blocks.Portal;
import uet.oop.bomberman.entities.blocks.Wall;
import uet.oop.bomberman.entities.item.FlameItem;
import uet.oop.bomberman.graphics.Sprite;

import java.util.ArrayList;
import java.util.List;

import static uet.oop.bomberman.control.SoundManager.updateSound;
import static uet.oop.bomberman.graphics.MapLevel.mapArr;
import static uet.oop.bomberman.graphics.MapLevel.setMapArr;
public class BombermanGame extends Application {

    public static final int WIDTH = 31;
    public static final int HEIGHT = 13;
    
    private GraphicsContext gc;
    private Canvas canvas;
    private List<Entity> entities = new ArrayList<>();
    private List<Entity> stillObjects = new ArrayList<>();

    public static Entity bomberman;

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
        entities.add(bomberman);

        scene.setOnKeyPressed(event -> {
            if (bomberman.isLife()) {
                Move move = new Move();
                switch (event.getCode()) {

                    case UP:
                        move.up(bomberman);
                        break;
                    case DOWN:
                        move.down(bomberman);
                        break;
                    case LEFT:
                        move.left(bomberman);
                        break;
                    case RIGHT:
                        move.right(bomberman);
                        break;
                    case SPACE:
                        System.out.println("space");
                        break;
                }
            }
        });
    }

    public void createMap() {
        setMapArr();
        for (int i = 0; i < WIDTH; i++) {
                for (int j = 0; j < HEIGHT; j++) {
                    Entity object;
                    if (mapArr[j][i] == '#') {
                        object = new Wall(i, j, Sprite.wall.getFxImage());
                    } else if(mapArr[j][i] == '*') {
                        object = new Brick(i, j, Sprite.brick.getFxImage());

                    } else {
                        object = new Grass(i, j, Sprite.grass.getFxImage());
                    }
                    stillObjects.add(object);
                }
            }

    }

    public void update() {

        entities.forEach(Entity::update);
        updateSound();
    }

    public void render() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        stillObjects.forEach(g -> g.render(gc));
        entities.forEach(g -> g.render(gc));
    }
}
