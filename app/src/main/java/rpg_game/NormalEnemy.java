package rpg_game;
public class NormalEnemy extends Enemy {

    public NormalEnemy(int level){
        super(level);
        this.damage = this.damage * this.getLevel() * 2;
        this.maxHealth = this.maxHealth * this.getLevel() * 2;
        this.gold = this.gold * this.getLevel() * 2;
        this.xp = this.xp * this.getLevel() * 2;
        this.health = this.maxHealth;
    }
   
}
