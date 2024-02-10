package rpg_game;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public abstract class NPC {
    protected Player player;
    protected Scanner scanner = new Scanner(System.in);
    protected List<Item> inventory = new ArrayList<>();
    protected int inventorySize = 3;
    protected String name;

    // private Item[] refreshItems(){
    
    // }
    protected String getName(){
        return name;
    }
    protected void setName(String newName){
        name = newName;
    }
    protected abstract void greetPlayer();
    
}
