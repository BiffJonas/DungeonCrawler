package rpg_game;
import java.util.Random;
public abstract class Enemy {
    Random random = new Random();
    protected int health = 100;
    protected int damage = 1110;
    protected int level;
    protected int gold = 10;
    protected int xp = 10;
    protected int maxHealth = health;

    public int getGold() {
        return random.nextInt(gold, gold * 3);
    }
    public int getXp() {
        return random.nextInt(xp, xp * 3);
    }
    public Enemy(int playerLevel){
        this.level = random.nextInt(playerLevel, playerLevel + 5);
    }
    public int getHealth(){
        return health;
    }
    public int getLevel() {
        return level;
    }
    public String getName(){
        return getClass().getSimpleName();
    }
    public boolean isAlive(){
        if (this.health > 0){
            return true;
        }else {
            System.out.println("You have slain the " + this.getName() + "!");
            System.out.println("Xp Gained:" + this.getXp());
            System.out.println("Gold Collected:" + this.getGold());
            return false;
        }

    }
    public void takeDamage(int damage){
        this.health -= damage;
        System.out.println(
                "you deal " +
                damage +
                " damage to the " +
                this.getName());
    }

    public void attack(Player player){
        player.takeDamage(this);
    }
    public int getMaxHealth() {
        return maxHealth;
    }
	public int getDamage() {
		return this.damage;
	}
}
