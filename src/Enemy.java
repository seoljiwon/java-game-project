import java.awt.*;


public class Enemy {
    ImageObject imageObj;

    int damage;

    int x;

    int y;

    public Enemy(ImageObject imageObj, int damage, int x, int y) {
        this.imageObj = imageObj;
        this.damage = damage;
        this.x = x;
        this.y = y;
    }

    public void move() {
        x -= 5;
        if (x < -40) {
            x = 900;
        }
    }

}

