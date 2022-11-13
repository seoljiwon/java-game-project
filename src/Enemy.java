import coordinate.*;

public class Enemy {
    ImageObject imageObject;

    int damage;

    int x;

    int y;

    public Enemy(ImageObject imageObject, int damage, int x, int y) {
        this.imageObject = imageObject;
        this.damage = damage;
        this.x = x;
        this.y = y;
    }

    public void move() {
        x -= 8;
        if (x < -40) {
            x = 900;
        }
    }

    public void crash(Character character) {
        if (Collision.isCollided(this.x, this.y, character.x, character.y, this.imageObject.getWidth(), this.imageObject.getHeight(), character.imageObject.getWidth(), character.imageObject.getHeight())) {
            character.hp = character.hp - damage < 0 ? 0 : character.hp - damage;

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                    }
                }

            }).start();
        }
    }
}