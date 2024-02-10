package rpg_game;
public class EasyEnemy extends Enemy { 
    public EasyEnemy(int level){
        super(level);
        this.damage = this.damage * this.getLevel();
        this.maxHealth = this.maxHealth * this.getLevel();
        this.gold = this.gold * this.getLevel();
        this.xp = this.xp * this.getLevel();
        this.health = this.maxHealth;
    }
    
}
