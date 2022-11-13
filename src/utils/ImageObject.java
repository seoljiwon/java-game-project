import java.awt.*;

public class ImageObject {
    Toolkit tk = Toolkit.getDefaultToolkit();
    Image image;
    String path;
    int width;
    int height;
    int hints = 10;

    ImageObject(String path, int width, int height) {
        this.width = width;
        this.height = height;
        this.path = path;
        this.image = getImage(path);
    }

    public Image getImage(String path) {
        return tk.getImage(path).getScaledInstance(width, height, hints);
    }
}