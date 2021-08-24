package kg.geektech.game.players;
//Добавить еще игрока, Golem, который имеет увеличенную жизнь но слабый удар.
//Может принимать на себя 1/5 часть урона исходящего от босса по другим игрокам.

public class Golem extends Hero {

    public Golem(int health, int damage) {

        super(health, damage, SuperAbility.TAKES_SOME_OF_THE_DAMAGE);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int golemTakenDamage = boss.getDamage() / 5;
        int aliveHeroes = 0;
        for (int i = 0; i < heroes.length; i++) {
            if (this != heroes[i] && heroes[i].getHealth() > 0 && heroes[i].getSuperAbility() != SuperAbility.SUMMONED_ANGEL_OR_RAVEN) {
                aliveHeroes++;
                heroes[i].setHealth(heroes[i].getHealth() + golemTakenDamage);
            }
        }
        int sumDamage = golemTakenDamage * aliveHeroes;
        this.setHealth(this.getHealth() - sumDamage);
        System.out.println("Golem took the damage: " + sumDamage);
    }
}
