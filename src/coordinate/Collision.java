package coordinate;
public class Collision {
    public static boolean isCollided(int x1, int y1, int x2, int y2, int w1, int h1, int w2, int h2) {
        if (Math.abs((x1 + w1 / 2) - (x2 + w2 / 2)) < (w2 / 2 + w1 / 2)
                && Math.abs((y1 + h1 / 2) - (y2 + h2 / 2)) < (h2 / 2 + h1 / 2)) {
            return true;
        } else {
            return false;
        }

    }
}
