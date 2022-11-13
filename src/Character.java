import coordinate.ImageObject;
public class Character {
    ImageObject imageObj;
    int hp;
    int speed;
    int jumpScale = 40;

    // character coordinates
    int x;
    int y;


    public Character(ImageObject imageObj, int hp, int speed) {
        this.imageObj = imageObj;
        this.hp = hp;
        this.speed = speed;

        init();
    }

    public void init() {
        x = 100;
        y = 345;
        imageObj.image = imageObj.getResizedImage(imageObj.path);
    }

    public void jump(int jumpScale) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                int jumpDiv = 5;
                for (int i = 0; i < jumpDiv; i++) {
                    try {
                        y -= jumpScale / jumpDiv;
                        Thread.sleep(30);
                    } catch (Exception e) {
                    }
                }

                for (int i = 0; i < jumpDiv; i++) {
                    try {
                        y += jumpScale / jumpDiv;
                        Thread.sleep(30);
                    } catch (Exception e) {
                    }
                }

                init();
            }

        }).start();
    }

    public void slide() {
        y += 5;
        imageObj.image = imageObj.image.getScaledInstance(imageObj.getWidth(), imageObj.getHeight() / 2, imageObj.getHints());

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(400);
                } catch (Exception e) {
                }

                init();
            }

        }).start();
    }

    public void move(KeyEventListener keyEventListener) {
        if (keyEventListener.keyUp == true) jump(jumpScale);
        if (keyEventListener.keyDown == true) slide();
    }
}
