public class BombEnemy extends Enemy {
    ImageObject boomImg = new ImageObject("src/image/boomm.png", 40, 40);

    BombEnemy(ImageObject imageObj, int damage, int x, int y) {
        super(imageObj, damage, x, y);
    }

    @Override
    public void move() {
        x -= 10;
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
