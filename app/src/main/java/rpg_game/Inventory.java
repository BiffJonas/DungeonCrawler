package rpg_game;
import java.util.List;
import java.util.ArrayList;

public class Inventory {
    private List<Item> items = new ArrayList<>();
    
    public void open(){
        System.out.println("INVENTORY:");
        for (Item item : items) {
            System.out.println(item.getName());
        }
    }
    public Item itemExists(String itemName){
        for(Item item : items){
            if(item.getName().equalsIgnoreCase(itemName)){
                return item;
            }
        }
        return null;
    }
    public void add(Item item){
        items.add(item);
    }
    public void remove(Item item){
        items.remove(item);
    }
}
