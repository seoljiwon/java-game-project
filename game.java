import javax.swing.*;
import java.awt.*;

public class game {
    public static void main(String[] ar){
        GameFrame frame = new GameFrame();
    }
}

class GameFrame extends JFrame{
    int F_WIDTH = 800;
    int F_HEIGHT = 600;

    // toolkit for getting image
    Toolkit tk = Toolkit.getDefaultToolkit();

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
    }
    public void start(){
    }
}