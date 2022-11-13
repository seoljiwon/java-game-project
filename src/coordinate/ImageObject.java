package coordinate;

import java.awt.*;

public class ImageObject {
    Toolkit tk = Toolkit.getDefaultToolkit();
    public Image image;
    public String path;
    int width;
    int height;
    int hints = 10;

    public ImageObject(String path, int width, int height) {
        this.width = width;
        this.height = height;
        this.path = path;
        this.image = getResizedImage(path);
    }

    public Image getResizedImage(String path) {
        return tk.getImage(path).getScaledInstance(width, height, hints);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getHints() {
        return hints;
    }
}