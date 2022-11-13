import java.awt.*;

public class Character {
    Image image;
    int hp;
    int speed;

    // character coordinates
    int x = 100;
    int y = 365;

    public Character(Image image, int hp, int speed) {
        this.image = image;
        this.hp = hp;
        this.speed = speed;
    }

    public void jump() {
        y -= 5;
    }

    public void slide() {
        x += 2;
    }

    public void move(KeyEventListener keyEventListener) {
        if (keyEventListener.keyUp == true) jump();
        if (keyEventListener.keyDown == true) slide();
    }
}
