import coordinate.ImageObject;

public class DescendingEnemy extends EnemyAbstract {
    public DescendingEnemy(ImageObject imageObj, int damage, int x, int y) {
        this.imageObj = imageObj;
        this.damage = damage;
        this.x = x;
        this.y = y;
    }

    @Override
    public void move() {
        x -= 8;
        if (y < 12) {
            y += 4;
        }
    }

}