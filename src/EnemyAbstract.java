import coordinate.*;

public abstract class EnemyAbstract {
    public ImageObject imageObj;
    public int damage;
    public int x;
    public int y;

    public void move() {
    }

    public void crash(Character character) {
        if (Collision.isCollided(this.x, this.y, character.x, character.y, this.imageObj.getWidth(), this.imageObj.getHeight(), character.imageObj.getWidth(), character.imageObj.getHeight())) {
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
