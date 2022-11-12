import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameFrame extends JFrame implements KeyListener, Runnable{
    int F_WIDTH = 800;
    int F_HEIGHT = 600;

    int x, y; // character coordinates
    boolean KeyUp = false;
    boolean KeyDown = false;
    boolean KeyLeft = false;
    boolean KeyRight = false;
    boolean KeySpace = false;

    Thread th;

    // toolkit for getting image
    Toolkit tk = Toolkit.getDefaultToolkit();
    Image characterImg = tk.getImage("jelly.png").getScaledInstance(30, 38, 10);
    Image backgroundImg = tk.getImage("chocolate.png").getScaledInstance(800,200, 10);

    GameFrame(){
        // component setting for frame
        init();
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
    public void init(){
        // init character coordinates
        x = 100;
        y = 365;
    }
    public void start(){
        // close btn operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addKeyListener(this);
        th = new Thread(this);
        th.start();
    }

    public void run(){ // thread infinite loop
        try{
            while(true){
                KeyProcess(); // update coordinates with keyboard input
                repaint(); // paint new image with updated coordinates
                Thread.sleep(20); // run thread with 20 milli sec
            }
        }catch (Exception e){}
    }

    public void paint(Graphics g){
        g.clearRect(0, 0, F_WIDTH, F_HEIGHT);
        g.drawImage(characterImg, x, y, this);
        g.drawImage(backgroundImg, 0, 400, this);
    }

    public void keyPressed(KeyEvent e){
        switch(e.getKeyCode()){
            case KeyEvent.VK_UP :
                KeyUp = true;
                break;
            case KeyEvent.VK_DOWN :
                KeyDown = true;
                break;
            case KeyEvent.VK_LEFT :
                KeyLeft = true;
                break;
            case KeyEvent.VK_RIGHT :
                KeyRight = true;
                break;
            case KeyEvent.VK_SPACE:
                KeySpace = true;
                break;
        }
    }

    public void keyReleased(KeyEvent e){
        switch(e.getKeyCode()){
            case KeyEvent.VK_UP :
                KeyUp = false;
                break;
            case KeyEvent.VK_DOWN :
                KeyDown = false;
                break;
            case KeyEvent.VK_LEFT :
                KeyLeft = false;
                break;
            case KeyEvent.VK_RIGHT :
                KeyRight = false;
                break;
            case KeyEvent.VK_SPACE:
                KeySpace = false;
                break;
        }
    }

    public void keyTyped(KeyEvent e){}

    public void KeyProcess(){
        // move character with keyboard input
        if(KeyUp == true) y -= 5;
        if(KeyDown == true) y += 5;
        if(KeyLeft == true) x -= 5;
        if(KeyRight == true) x += 5;
        if(KeySpace == true) y -= 5;
    }
}