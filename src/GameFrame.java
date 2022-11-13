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

    ImageObject backgroundImg = new ImageObject("src/image/chocolate.png",800,200);

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
                repaint(); // paint new image with updated coordinates
                Thread.sleep(20); // run thread with 20 milli sec
            }
        }catch (Exception e){}
    }

    public void paint(Graphics g){
        g.clearRect(0, 0, F_WIDTH, F_HEIGHT);
        g.drawImage(characterImg.image, character.x, character.y, this);
        g.drawImage(backgroundImg.image, 0, 400, this);
    }
}