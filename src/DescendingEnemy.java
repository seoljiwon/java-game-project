public class DescendingEnemy extends Enemy {
    DescendingEnemy(ImageObject imageObj, int damage, int x, int y) {
        super(imageObj, damage, x, y);
    }

    public void move() {
        if (y < 24) {
            y += 4;
            x -= 5;
        } else if (y == 24) {
            x -= 5;
        }
    }

}
