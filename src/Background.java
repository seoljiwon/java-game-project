import coordinate.ImageObject;

public class Background {
    ImageObject imageObject;

    int x = 0;
    int y;

    public Background(ImageObject imageObject) {
        this(imageObject, 0);
    }

    public Background(ImageObject imageObj, int y) {
        this.imageObject = imageObj;
        this.y = y;
    }

    public void move(int speed) {
        x -= speed;
        if (x < -800) {
            x = 0;
        }
    }
}