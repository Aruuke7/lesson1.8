package kg.geektech.game.players;

public class Witcher extends Hero{
    public Witcher(int health) {
        super(health, SuperAbility.REVIVES_THE_FIRST_DECEASED);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() == 0) {
                if (this.getHealth() > 0) {
                    heroes[i].setHealth(heroes[i].getHealth() + this.getHealth());
                    this.setHealth(0);
                    System.out.println("Witcher revives and gave his life");

                }else break;

            }
        }
    }
}
