package rpg_game;
import java.util.Random;

public abstract class Item {
    private int cost;
    private int level = 0;
    private Random random = new Random();

    // public Item(Player player){
    //     level = random.nextInt(player.getLevel() - 5, player.getLevel() + 2 );

    // }
    
    public void setCost(){
        this.cost = random.nextInt(this.level * 10, this.level * 20);
    }
    public int getCost(){
        return this.cost;
    }
    public void setLevel(int playerLevel){
        this.level = random.nextInt(playerLevel - 5, playerLevel + 2);
        if(this.level <= 0){
            this.level = 1;
        }
    }
    public int getLevel(){
        return this.level;
    }

    public String getName(){
        return getClass().getSimpleName();
    }
}
