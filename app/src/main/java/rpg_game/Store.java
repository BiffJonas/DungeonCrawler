package rpg_game;

public abstract class Store extends Location implements Interactive {
    
    Seller seller; 
    protected Item[] allItems = new Item[]{new ChestPlate(10), new Leggings(10), new Boots(10)};
    protected abstract void setSeller();

    public void enter(Player player) {
        this.setSeller();
        seller.populateInventory();
        refreshItems(player.getLevel());

        System.out.println("You enter the " + getName());
        seller.greetPlayer();

        while(true){
            int choice = showChoices();
            if(choice == 0){
                seller.listWares(player);
                player.inventory.open();
            }
            if(choice == 3){
                break;
            }
        }
        System.out.println("Leaving the " + getName() + "...");
    }
    
    protected void refreshItems(int playerLevel){
        for (Item item : allItems){
            item.setLevel(playerLevel);
            item.setCost();
        }
    }
}
