import coordinate.ImageObject;

public class DescendingEnemy extends Enemy {
    public DescendingEnemy(ImageObject imageObject, int damage, int x, int y) {
        super(imageObject, damage, x, y);
    }

    public void move() {
        x -= 8;
        if (y < 12) {
            y += 4;
        }
    }

}