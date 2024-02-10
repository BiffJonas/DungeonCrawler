package rpg_game;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Random;

public abstract class Seller extends NPC {
    protected Store store;

    public Seller(Store store){
        this.store = store;
    }
    protected void sellItems(Player player){
        System.out.println("Choose an item to buy or q to stop browsing");
        while (true){

            String itemName = scanner.next();
            Item item = this.getSoldItem(itemName);

            if(itemName.equals("q")) return;

            if(!this.hasItem(item)) continue;

            if(!player.canAfford(item)){
                System.out.println(this.getName() + ": Sorry, looks like you can't afford that");
                continue;
            }
                inventory.remove(item);
                player.buyItem(item);
        }
    }
    private boolean hasItem(Item item){
        if (inventory.contains(item)) {
           return true; 
        }else {
        System.out.println(getName() + ": I'm afraid i don't have that.");
        return false;
        }
    }
    protected Item getSoldItem(String itemName){
            for (Item item : inventory){
                if(item.getName().equalsIgnoreCase(itemName)){
                    return item;
                }
            }
            return null;
    }


    protected void listWares(Player player){
        if(!hasItems()) return;

        System.out.println(getName() + ": Anything catching your eye?");
        for (int i = 0; i < inventory.size(); i++){
            Item item = inventory.get(i);
            System.out.println(item.getName() + " Level: " + item.getLevel() + " Cost: " + item.getCost());
        }
        sellItems(player);
    }


    protected boolean hasItems(){
        if (inventory.size() <= 0){
            System.out.println(getName() + ": Sorry, come back once i've restocked my wares");
            return false;
        }
        return true;
    }
    
    protected List<Item> populateInventory(){
        this.inventory.removeAll(this.inventory);

        List<Item>allItemsList = new ArrayList<>(Arrays.asList(store.allItems));
        for (int i = 0; i < inventorySize; i++ ) {
            Random random = new Random();
            int randomIndex = random.nextInt(allItemsList.size());
            inventory.add(allItemsList.get(randomIndex));
            allItemsList.remove(randomIndex);
            
        }
        return inventory;
    }
    
}
