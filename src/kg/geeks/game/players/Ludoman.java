package kg.geeks.game.players;

import kg.geeks.game.logic.RPG_Game;

public class Ludoman extends Hero {
    public Ludoman(int health, int damage, String name) {
        super(health, damage, name, SuperAbility.DICES_THROW);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int dice1 = RPG_Game.random.nextInt(6) + 1;
        int dice2 = RPG_Game.random.nextInt(6) + 1;
        if (dice1 == dice2) {
            int damage = dice1 * dice2;
            boss.setHealth(boss.getHealth() - damage);
            System.out.println(this.getName() + " threw the dice: " + dice1 + " and " + dice2 +
                    ". Dice numbers coincided! Boss loose " + damage + " heal points.");
        } else {
            int damage = dice1 + dice2;
            Hero randomHero = heroes[RPG_Game.random.nextInt(heroes.length)];
            if (randomHero != this && randomHero.getHealth() > 0) {
                randomHero.setHealth(randomHero.getHealth() - damage);
                System.out.println(this.getName() + " threw the dice: " + dice1 + " and " + dice2 +
                        ". Dice numbers didn't match! " + randomHero.getName() +
                        " loose " + damage + " heal points.");
            }
        }
    }
}