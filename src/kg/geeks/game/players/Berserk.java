package kg.geeks.game.players;

public class Berserk extends Hero {
    private int blockedDamage;

    public Berserk(int health, int damage, String name) {
        super(health, damage, name, SuperAbility.BLOCK_DAMAGE_REVERT);
    }

    public void setBlockedDamage(int blockedDamage) {
        this.blockedDamage = blockedDamage;
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] hero) {
        boss.setHealth(boss.getHealth() - blockedDamage);
        System.out.println("Berserk " + this.getName() + " reverted "
                + blockedDamage + " damage to boss.");
    }
}
