import coordinate.ImageObject;

public class BombEnemy extends EnemyAbstract {
    ImageObject boomImg = new ImageObject("image/boomm.png", 40, 40);

    public BombEnemy(ImageObject imageObj, int damage, int x, int y) {
        this.imageObj = imageObj;
        this.damage = damage;
        this.x = x;
        this.y = y;
    }

    @Override
    public void move() {
        x -= 7;
    }

    public void descend() {
        if (y < 360) {
            y += 5;
        } else if (y == 360) {
            this.bomb();
        }
    }

    public void bomb() {
        this.imageObj = boomImg;
        this.move();
    }
}