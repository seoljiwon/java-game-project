public class DescendingEnemy extends Enemy {
    DescendingEnemy(ImageObject imageObj, int damage, int x, int y) {
        super(imageObj, damage, x, y);
    }

    public void move() {
        if (y < 12) {
            y += 4;
            x -= 5;
        } else if (y == 12) {
            x -= 5;
        }
    }

}
