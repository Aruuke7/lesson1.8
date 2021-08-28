package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;

import java.util.Random;

public class Magic extends Hero {
    public Magic(int health, int damage) {
        super(health, damage, SuperAbility.BOOST);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int increasedDamage = RPG_Game.random.nextInt(8)+2;

        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0){
                if (this != heroes[i] && heroes[i].getSuperAbility() != SuperAbility.REVIVES_THE_FIRST_DECEASED
                && heroes[i].getSuperAbility() != SuperAbility.SUMMONED_ANGEL_OR_RAVEN
                        && heroes[i].getSuperAbility() != SuperAbility.STUN
                        && heroes[i].getSuperAbility() != SuperAbility.FREEZE){
                    heroes[i].setDamage(heroes[i].getDamage() + increasedDamage);
                }
            }

        }System.out.println("Magic increased the damage: " + increasedDamage);

    }
}
