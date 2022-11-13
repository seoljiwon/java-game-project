import coordinate.*;

public class Enemy extends EnemyAbstract {
    public Enemy(ImageObject imageObj, int damage, int x, int y) {
        this.imageObj = imageObj;
        this.damage = damage;
        this.x = x;
        this.y = y;
    }

    @Override
    public void move() {
        x -= 8;
        if (x < -40) {
            x = 900;
        }
    }

}