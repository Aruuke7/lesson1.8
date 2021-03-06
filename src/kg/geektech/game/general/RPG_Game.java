package kg.geektech.game.general;

import kg.geektech.game.players.*;

import java.util.Random;

public class RPG_Game {

    public static Random random = new Random();

    public static void startGame() {

        Boss boss = new Boss(1200, 50);
        Warrior warrior = new Warrior(270, 15);
        Medic support = new Medic(230, 5, 20);
        Magic magic = new Magic(260, 20);
        Berserk berserk = new Berserk(280, 10);
        Medic assistant = new Medic(250, 10, 10);
        Golem golem = new Golem(400,10);
        Witcher witcher = new Witcher(250);
        Thor thor = new Thor(250);
        Loki loki = new Loki(400);
        Hero[] heroes = {warrior, support, magic, berserk, assistant, golem, witcher, thor};



        printStatistics(boss, loki ,heroes);
        while (!isGameFinished(boss, heroes)) {
            round(boss, loki, heroes);
        }
    }

    private static void heroesApplySuperAbilities(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0) {
                heroes[i].applySuperPower(boss, heroes);
            }
        }
    }

    private static void heroesHit(Boss boss, Loki loki, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0) {
                boss.setHealth(boss.getHealth() - heroes[i].getDamage());
                loki.setHealth(loki.getHealth() - heroes[i].getDamage());
            }
        }
    }

    private static void bossHits(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0)
                heroes[i].setHealth(heroes[i].getHealth()
                        - boss.getDamage());
        }
    }

    private static void round(Boss boss, Loki loki, Hero[] heroes) {
        boss.setStun(random.nextBoolean());
        if (!boss.isStun()){
            bossHits(boss, heroes);
        }else {
            System.out.println("Boss is stunned!");
        }
        boolean allHeroesAreFrozen = random.nextBoolean();
        if (!allHeroesAreFrozen) {
            heroesHit(boss, loki, heroes);
            heroesApplySuperAbilities(boss, heroes);
        }else if (loki.getHealth() > 0){
            System.out.println("Heroes are frozen!");
        }
        printStatistics(boss, loki, heroes);
    }

    private static void printStatistics(Boss boss, Loki loki, Hero[] heroes) {
        System.out.println("___________");
        System.out.println("Boss health: " + boss.getHealth() +
                " [" + boss.getDamage() + "]");
        System.out.println("Loki health: " + loki.getHealth() +
                " [" + loki.getDamage() + "]");
        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i].getClass().getSimpleName()
                    + " health: " + heroes[i].getHealth() +
                    " [" + heroes[i].getDamage() + "]");
        }
        System.out.println("___________");
    }

    private static boolean isGameFinished(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("Boss won!!!");
        }
        return allHeroesDead;
    }

}
