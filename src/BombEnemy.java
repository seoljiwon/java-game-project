import coordinate.ImageObject;

public class BombEnemy extends Enemy {
    ImageObject boomImage = new ImageObject("image/boomm.png", 40, 40);

    public BombEnemy(ImageObject imageObject, int damage, int x, int y) {
        super(imageObject, damage, x, y);
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
        this.imageObject = boomImage;
        this.move();
    }
}