import coordinate.ImageObject;

public class Background {
    ImageObject imageObject;

    int x = 0;
    int y;

    public Background(ImageObject imageObject) {
        this(imageObject, 0);
    }

    public Background(ImageObject imageObject, int y) {
        this.imageObject = imageObject;
        this.y = y;
    }

    public void move(int speed) {
        x -= speed;
        if (x < -800) {
            x = 0;
        }
    }
}