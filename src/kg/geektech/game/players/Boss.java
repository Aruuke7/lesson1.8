package kg.geektech.game.players;

public class Boss extends GameEntity {
    boolean stun;

    public Boss(int health, int damage) {
        super(health, damage);
    }

    public boolean isStun() {
        return stun;
    }

    public void setStun(boolean stun) {
        this.stun = stun;
    }
}
