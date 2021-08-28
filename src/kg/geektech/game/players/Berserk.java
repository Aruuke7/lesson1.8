package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;

import java.util.Random;

public class Berserk extends Hero {
    public Berserk(int health, int damage) {
        super(health, damage,
                SuperAbility.SAVE_DAMAGE_AND_REVERT);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {

        int partOfTheDamage = (boss.getDamage() / (RPG_Game.random.nextInt(3)+2));
        boss.setHealth(boss.getHealth() - partOfTheDamage );
        this.setHealth(this.getHealth() + partOfTheDamage);

        System.out.println("Berserk blocked damage: " + partOfTheDamage);

    }
}
