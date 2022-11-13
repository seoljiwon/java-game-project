public class DescendingEnemy extends Enemy {
    DescendingEnemy(ImageObject imageObj, int damage, int x, int y) {
        super(imageObj, damage, x, y);
    }

    public void move() {
        x -= 8;
        if (y < 12) {
            y += 4;
        }
    }

}
