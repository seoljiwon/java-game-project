import java.awt.*;

public class Background {
    Image image;

    int x = 0;
    int y = 0;

    public Background(Image image) {
        this(image, 0);
    }

    public Background(Image image, int y) {
        this.image = image;
        this.y = y;
    }

    public void move() {
        x -= 5;
        if (x < -800) {
            x = 0;
        }
    }
}
