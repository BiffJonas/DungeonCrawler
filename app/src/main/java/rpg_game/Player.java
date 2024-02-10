package rpg_game;
import java.util.Scanner;

public class Player {

    public Armor armor = new Armor();
    // public PrimaryWeapon primaryWeapon = new PrimaryWeapon();
    // public SecondaryWeapon SecondaryWeapon = new SecondaryWeapon();
    // public Role role;
    public Inventory inventory = new Inventory();
    public Scanner scanner = new Scanner(System.in);
	private String name;
    private int level = 1;
    private int maxHealth = 200;
	private int health = maxHealth;
    private int damage = 100;
    private int xp = 0;
	private int xpToLevelUp = 100 * level;
    private int gold = 100;
    private int defense = armor.getArmorScore();
    public boolean isAlive = true;

    
	public void equipItem(Item piece){
        switch (piece.getName()) {
            case "ChestPlate": 
                armor.equipChestPlate((ChestPlate)piece);
                break;
            case "Leggings":
                armor.equipLeggings((Leggings)piece);
                break;
            case "Boots":
                armor.equipBoots((Boots)piece);
                break;
        }

    }
    public void showOptions(){
        //location should have a field called options that specifies
        //the available options for that location.
        //Current action options would also reduce the amount of code i need to write... i think
        System.out.println("What would you like to do?");
        while(true){
            System.out.println("Nothing(0), Check Inventory(1), Check Travel Options(2), Show Stats(3)");
            int choice = scanner.nextInt();
            if ( choice == 1 ){
                inventory.open();
                showInventoryOptions();
            }else if (choice == 2){
                System.out.println("Showing Travel Options");
            }else if (choice == 3){
                showStats();
            }else if (choice == 0){
                break;
            }

        }
    }
    public void equipmentSelection(){
        //TODO: this doesnt seem to work as expected. pressing e skips 
        inventory.open();
        System.out.println("Type the name of the item you want to equip, or 'Q' to go back to inventory");
        while(true){
            String itemToEquip = scanner.next();

            if(itemToEquip.equalsIgnoreCase("Q")) break;

            //returns null if item doesn't exist
            Item item = inventory.itemExists(itemToEquip);

            if(item == null) return;
            equipItem(item);
            inventory.remove(item);
            updateDefenseValue();
        }
    }
    public void buyItem(Item itemBought){
        this.setGold(-itemBought.getCost());
        this.inventory.add(itemBought);
    }
    public int getLevel(){
        return this.level;
    }


    public int getHealth(){
        return this.health;
    }

    public int getMaxHealth() {
		return maxHealth;
	}


    public int getDefense(){
        return this.defense;
    }
    public int getDamage(){
        return this.damage;
    }

    public int getGold(){
        return this.gold;
    }
    public void setGold(int cost){
        this.gold += cost;
    }
    public void attack(Enemy enemy, String hello){
        enemy.takeDamage(damage);
    }
    public void takeDamage(Enemy enemy){
        int damageToTake = enemy.getDamage() - this.defense;
        if (damageToTake < enemy.getDamage() / 10){
            damageToTake = enemy.getDamage() / 10;
        }
        health -= damageToTake;
        System.out.println(
                enemy.getName() +
                " attacks you dealing " +
                damageToTake
                );
    }
    public void setName(String name) {
    	this.name = name;
	}
    public String getName() {
    	return name;
	}

    

    public Armor getArmor() {
		return armor;
	}
    public void setArmor(Armor armor) {
		this.armor = armor;
	}


	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
	public Scanner getScanner() {
		return scanner;
	}
	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	public void setDefense(int defense) {
		this.defense = defense;
	}
	public void getRewards(Enemy enemy) {
        this.setGold(enemy.getGold());
        this.setXp(enemy.getXp());
	}
	public void setXp(int xp){
        this.xp += xp;
        if( this.checkLevelUp() ){
            this.levelUp();
            this.reCalculateStats();
        }

    }
	public boolean getIsAlive() {
        return this.isAlive;
	}
	public void setIsAlive(boolean bool) {
        this.isAlive = bool;
	}
    public void revive() {
            System.out.println("You wake up at home feeling disoriented");
            setIsAlive(true);
	}
    protected boolean canAfford(Item item){
        return this.gold >= item.getCost();
    }
	private void showStats(){
        System.out.println("Level: " + getLevel());
        System.out.println("Damage: " + getDamage());
        System.out.println("Defense: " + getDefense());
        System.out.println("Health: " + getHealth());
        System.out.println("Gold: " + getGold());
    }
	private void showInventoryOptions(){
        while(true){
            System.out.println("Inventory Options:");
            System.out.println("Equip item(E), Use item(U), Close inventory(Q)");
            String inventoryChoice = scanner.next();
            if(inventoryChoice.equalsIgnoreCase("e")){
                equipmentSelection();
            }else if(inventoryChoice.equalsIgnoreCase("u")){
                System.out.println("Type the name of the item you want to use?");
            }else if(inventoryChoice.equalsIgnoreCase("q")){
                System.out.println("Leaving Inventory menu");
                break;
            }
        }
    }
	private void updateDefenseValue(){
        this.defense = armor.getArmorScore();
    }
	private void levelUp() {
        this.level++;
        this.xp = 0;
        System.out.println("You are now level " + getLevel() + "!");
	}
	private void reCalculateStats() {
        this.maxHealth =  200 + (this.level * 100);
        this.health = this.maxHealth;
        this.damage = 100 + (this.level  * 10);
        this.xpToLevelUp = 100 + (level * 10);
	}
	private boolean checkLevelUp() {
        return this.xp >= this.xpToLevelUp;
	}
}
