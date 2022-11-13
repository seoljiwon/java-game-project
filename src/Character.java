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
        y = 365;
        imageObj.image = imageObj.getImage(imageObj.path);
    }

    public void jump(int jumpScale) {
        y -= jumpScale;
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                }

                init();
            }

        }).start();
    }

    public void slide() {
        y += 5;
        imageObj.image = imageObj.image.getScaledInstance(imageObj.width, imageObj.height / 2, imageObj.hints);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(100);
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
