public class Enemy {
    ImageObject imageObj;

    int damage;

    int x;

    int y;

    public Enemy(ImageObject imageObj, int damage, int x, int y) {
        this.imageObj = imageObj;
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
        if (Collision.isCollided(this.x, this.y, character.x, character.y, this.imageObj.width, this.imageObj.height, character.imageObj.width, character.imageObj.height)){
            character.hp -= damage;

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

