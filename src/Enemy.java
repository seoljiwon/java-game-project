import java.awt.*;


public class Enemy {
    Image image;

    int damage;

    int x;

    int y = 365;

    public Enemy(Image image, int damage, int x) {
        this.image = image;
        this.x = x;
        this.damage = damage;
    }

    public void move() {
        x -= 5;
        if (x < -40) {
            x = 900;
        }
    }

}

