package coordinate;

public class Collision {
    public static boolean isCollided(int x1, int y1, int x2, int y2, int width1, int height1, int width2, int height2) {
        if (Math.abs((x1 + width1 / 2) - (x2 + width2 / 2)) < (width2 / 2 + width1 / 2)
                && Math.abs((y1 + height1 / 2) - (y2 + height2 / 2)) < (height2 / 2 + height1 / 2)) {
            return true;
        } else {
            return false;
        }

    }
}