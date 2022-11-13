import java.awt.*;

public class Background {
    ImageObject imageObj;

    int x = 0;
    int y;

    public Background(ImageObject imageObj) {
        this(imageObj, 0);
    }

    public Background(ImageObject imageObj, int y) {
        this.imageObj = imageObj;
        this.y = y;
    }

    public void move() {
        x -= 2;
        if (x < -800) {
            x = 0;
        }
    }
}
