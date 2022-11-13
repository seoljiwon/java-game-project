import java.awt.*;
import javax.swing.*;

import coordinate.ImageObject;


public class GameFrame extends JFrame implements Runnable {
    int FRAME_WIDTH = 800;
    int FRAME_HEIGHT = 600;

    Thread thread;
    Toolkit toolkit = Toolkit.getDefaultToolkit();
    KeyEventListener keyEventListener = new KeyEventListener();

    ImageObject characterImage = new ImageObject("image/jelly.png", 50, 65);
    Character character = new Character(characterImage, 1000, 2);

    ImageObject skyImage = new ImageObject("image/sky.png", 1600, 600);
    Background sky = new Background(skyImage);

    ImageObject floorImage = new ImageObject("image/floor.png", 1600, 200);
    Background floor = new Background(floorImage, 400);

    ImageObject enemyImage = new ImageObject("image/enemy_basic.png", 40, 40);
    
    Enemy enemy1 = new GroundEnemy(enemyImage, 30, 1600, 365);
    Enemy enemy2 = new GroundEnemy(enemyImage, 30, 2000, 365);

    ImageObject descendingEnemyImage = new ImageObject("image/descending.png", 50, 340);
    DescendingEnemy descendingEnemy = new DescendingEnemy(descendingEnemyImage, 30, 900, -300);

    ImageObject bombEnemyImage = new ImageObject("image/enemy_bomb.png", 40, 40);
    BombEnemy bombEnemy = new BombEnemy(bombEnemyImage, 30, 700, 0);


    // for double buffering
    Image buffImage;
    Graphics buffGraphics;

    GameFrame() {
        // component setting for frame
        start();

        setTitle("Jelly Run");
        setSize(FRAME_WIDTH, FRAME_HEIGHT);

        // get current screen value for frame location setting
        Dimension screen = toolkit.getScreenSize();

        int xPosition = (int) (screen.getWidth() / 2 - FRAME_WIDTH / 2);
        int yPosition = (int) (screen.getHeight() / 2 - FRAME_HEIGHT / 2);

        setLocation(xPosition, yPosition);
        setResizable(false);
        setVisible(true);
    }

    public void start() {
        // close btn operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addKeyListener(keyEventListener);

        thread = new Thread(this);
        thread.start();
    }

    public void run() { // thread infinite loop
        try {
            boolean running = true;
            while (running) {
                character.move(keyEventListener); // update coordinates with keyboard input
                sky.move(character.speed);
                floor.move(character.speed);
                enemy1.move();
                enemy2.move();
                enemy1.crash(character);
                enemy2.crash(character);
                descendingEnemy.move();
                descendingEnemy.crash(character);
                bombEnemy.descend();
                bombEnemy.crash(character);
                repaint(); // paint new image with updated coordinates
                Thread.sleep(20); // run thread with 20 milli sec

                if (character.hp == 0) {
                    running = false;
                }
            }
        } catch (Exception error) {
        }
    }

    public void paint(Graphics graphics) {
        buffImage = createImage(FRAME_WIDTH, FRAME_HEIGHT);
        buffGraphics = buffImage.getGraphics();

        update(graphics);
    }

    public void update(Graphics graphics) {
        draw();

        graphics.drawImage(buffImage, 0, 0, this);
    }

    public void draw() {
        buffGraphics.clearRect(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
        buffGraphics.drawImage(sky.imageObject.image, sky.x, sky.y, this);
        buffGraphics.drawImage(floor.imageObject.image, floor.x, floor.y, this);
        buffGraphics.drawImage(character.imageObject.image, character.x, character.y, this);
        buffGraphics.drawImage(enemy1.imageObject.image, enemy1.x, enemy1.y, this);
        buffGraphics.drawImage(enemy2.imageObject.image, enemy2.x, enemy2.y, this);
        buffGraphics.drawImage(descendingEnemy.imageObject.image, descendingEnemy.x, descendingEnemy.y, this);
        buffGraphics.drawImage(bombEnemy.imageObject.image, bombEnemy.x, bombEnemy.y, this);
        buffGraphics.setFont(new Font("Default", Font.BOLD, 15));
        buffGraphics.drawString("HP : " + character.hp, 700, 50);

        if (character.hp == 0) {
            buffGraphics.setFont(new Font("Default", Font.BOLD, 45));
            buffGraphics.drawString("GAME OVER", 265, FRAME_HEIGHT / 2);
        }
    }
}