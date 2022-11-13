import coordinate.ImageObject;

public class Character {
    ImageObject imageObject;
    int hp;
    int speed;
    int jumpScale = 40;

    // character coordinates
    int x;
    int y;


    public Character(ImageObject imageObject, int hp, int speed) {
        this.imageObject = imageObject;
        this.hp = hp;
        this.speed = speed;

        init();
    }

    public void init() {
        x = 100;
        y = 345;
        imageObject.image = imageObject.getResizedImage(imageObject.path);
    }

    public void jump(int jumpScale) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                int jumpDivision = 5;
                for (int i = 0; i < jumpDivision; i++) {
                    try {
                        y -= jumpScale / jumpDivision;
                        Thread.sleep(30);
                    } catch (Exception error) {
                        error.printStackTrace();
                    }
                }

                for (int i = 0; i < jumpDivision; i++) {
                    try {
                        y += jumpScale / jumpDivision;
                        Thread.sleep(30);
                    } catch (Exception error) {
                        error.printStackTrace();
                    }
                }

                init();
            }

        }).start();
    }

    public void slide() {
        y += 5;
        imageObject.image = imageObject.image.getScaledInstance(imageObject.getWidth(), imageObject.getHeight() / 2, imageObject.getHints());

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(400);
                } catch (Exception error) {
                    error.printStackTrace();
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