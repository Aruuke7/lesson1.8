package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;

public class Thor extends Hero{
    public Thor(int health) {
        super(health, SuperAbility.STUN);
    }


    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {


    }
}
