package kg.geektech.game.players;

public class Medic extends Hero {
    public int getHealPoints() {
        return healPoints;
    }

    public void setHealPoints(int healPoints) {
        this.healPoints = healPoints;
    }

    private int healPoints;

    public Medic(int health, int damage, int healPoints) {
        super(health, damage, SuperAbility.HEAL);
        this.healPoints = healPoints;
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                if (this != heroes[i] && heroes[i].getSuperAbility() != SuperAbility.SUMMONED_ANGEL_OR_RAVEN) {
                    heroes[i].setHealth(
                            heroes[i].getHealth() + healPoints);
                }
            }
        }
    }
}
