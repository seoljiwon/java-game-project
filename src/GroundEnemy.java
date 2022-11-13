import coordinate.*;

public class GroundEnemy extends Enemy {
    public GroundEnemy(ImageObject imageObject, int damage, int x, int y) {
        super(imageObject, damage, x, y);
    }

    @Override
    public void move() {
        x -= 8;
        if (x < -40) {
            x = 900;
            crashCount = 0;
        }
    }
}