public class BombEnemy extends Enemy {
    BombEnemy(ImageObject imageObj, int damage, int x, int y) {
        super(imageObj, damage, x, y);
        this.descend();
    }

    public void descend() {
        if (y < 360) {
            y += 5;
        } else if (y == 360) {
            this.bomb();
        }
    }

    public void bomb() {
        ImageObject boomImg = new ImageObject("src/image/boomm.png", 40, 40);
        this.imageObj=boomImg;
        this.move();
    }
}
