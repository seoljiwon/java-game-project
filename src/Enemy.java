import coordinate.*;

public class Enemy {
    ImageObject imageObject;

    int damage;

    int x;

    int y;
    
    int crashCount = 0;

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
            crashCount = 0;
        }
    }

    public void crash(Character character) {
        if (crashCount == 0 && Collision.isCollided(this.x, this.y, character.x, character.y, this.imageObject.getWidth(), this.imageObject.getHeight(), character.imageObject.getWidth(), character.imageObject.getHeight())) {
            character.hp = character.hp - damage < 0 ? 0 : character.hp - damage;
            crashCount += 1;
        }
    }
}