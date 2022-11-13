import java.awt.*;
import javax.swing.*;

public class GameFrame extends JFrame implements Runnable{
    int F_WIDTH = 800;
    int F_HEIGHT = 600;

    Thread th;
    Toolkit tk = Toolkit.getDefaultToolkit();
    KeyEventListener keyEventListener = new KeyEventListener();

    ImageObject characterImg = new ImageObject("src/image/jelly.png", 30, 38);
    Character character = new Character(characterImg.image, 100, 3);

    ImageObject skyImg = new ImageObject("src/image/sky.png",1600,600);
    Background sky = new Background(skyImg.image);

    ImageObject floorImg = new ImageObject("src/image/floor.png",1600,200);
    Background floor = new Background(floorImg.image, 400);

    // for double buffering
    Image buffImage;
    Graphics buffGraphics;

    GameFrame(){
        // component setting for frame
        start();

        setTitle("Jelly Run");
        setSize(F_WIDTH, F_HEIGHT);

        // get current screen value for frame location setting
        Dimension screen = tk.getScreenSize();

        int xPos = (int)(screen.getWidth() / 2 - F_WIDTH / 2);
        int yPos = (int)(screen.getHeight() / 2 - F_HEIGHT / 2);

        setLocation(xPos, yPos);
        setResizable(false);
        setVisible(true);
    }

    public void start(){
        // close btn operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addKeyListener(keyEventListener);

        th = new Thread(this);
        th.start();
    }

    public void run(){ // thread infinite loop
        try{
            while(true){
                character.move(keyEventListener); // update coordinates with keyboard input
                sky.move();
                floor.move();
                repaint(); // paint new image with updated coordinates
                Thread.sleep(20); // run thread with 20 milli sec
            }
        }catch (Exception e){}
    }

    public void paint(Graphics g){
        buffImage = createImage(F_WIDTH, F_HEIGHT);
        buffGraphics = buffImage.getGraphics();

        update(g);
    }

    public void update(Graphics g){
        draw();

        g.drawImage(buffImage, 0, 0, this);
    }

    public void draw(){
        buffGraphics.clearRect(0, 0, F_WIDTH, F_HEIGHT);
        buffGraphics.drawImage(sky.image, sky.x, sky.y, this);
        buffGraphics.drawImage(floor.image, floor.x, floor.y, this);
        buffGraphics.drawImage(character.image, character.x, character.y, this);
    }

}