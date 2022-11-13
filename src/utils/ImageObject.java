import java.awt.*;

public class ImageObject {
    Toolkit tk = Toolkit.getDefaultToolkit();
    Image image;
    int width;
    int height;

    ImageObject(String path, int width, int height){
        this.width = width;
        this.height = height;
        this.image = getImage(path);
    }

    public Image getImage(String path){
        return tk.getImage(path).getScaledInstance(width, height, 10);
    }
}