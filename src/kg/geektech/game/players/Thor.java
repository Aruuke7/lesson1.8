package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;

public class Thor extends Hero{
    public Thor(int health, int damage ) {
        super(health, damage, SuperAbility.STUN);
    }


    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {


    }
}
