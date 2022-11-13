import coordinate.*;

public abstract class Enemy {
    public ImageObject imageObject;
    public int damage;
    public int x;
    public int y;
    public int crashCount = 0;

    public Enemy(ImageObject imageObject, int damage, int x, int y) {
        this.imageObject = imageObject;
        this.damage = damage;
        this.x = x;
        this.y = y;
    }

    public abstract void move();

    public void crash(Character character) {
        if (crashCount == 0 && Collision.isCollided(this.x, this.y, character.x, character.y, this.imageObject.getWidth(), this.imageObject.getHeight(), character.imageObject.getWidth(), character.imageObject.getHeight())) {
            character.hp = character.hp - damage < 0 ? 0 : character.hp - damage;
            crashCount += 1;
        }
    }
}


