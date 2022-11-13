import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyEventListener implements KeyListener{
    boolean keyUp = false;
    boolean keyDown = false;

    public void keyPressed(KeyEvent e){
        switch(e.getKeyCode()){
            case KeyEvent.VK_UP :
                keyUp = true;
                break;
            case KeyEvent.VK_DOWN :
                keyDown = true;
                break;
        }
    }

    public void keyReleased(KeyEvent e){
        switch(e.getKeyCode()){
            case KeyEvent.VK_UP :
                keyUp = false;
                break;
            case KeyEvent.VK_DOWN :
                keyDown = false;
                break;
        }
    }

    public void keyTyped(KeyEvent e){}
}
