package kg.geektech.game.players;

public abstract class GameEntity {
    private int health;
    private int damage;
    private int originalDamage;


    public GameEntity(int health, int damage) {
        this.health = health;
        this.damage = damage;
        this.originalDamage = damage;
    }


    public GameEntity(int health){
        this.health = health;

    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health < 0) {
            this.health = 0;
        } else {
            this.health = health;
        }
    }

    public int getOriginalDamage() {
        return originalDamage;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
