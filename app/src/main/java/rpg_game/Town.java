package rpg_game;

public class Town extends Location implements Interactive{
    private Armory armory = new Armory();
    public void enter(Player player){
        while(true){
            System.out.println("You find youself in the middle of town");
            int choice = showChoices();
            if (choice == 0) return;

            if (choice == 1){
                System.out.println("Entering Tavern");
            } else if (choice == 2){
                armory.enter(player);
            }else if (choice == 3){
                System.out.println("Entering Wizard Hut");
            }
        }
    }
    public int showChoices(){
        System.out.println("Where would you like to go?");
        // Wizard hut: Heals, potions, magical items
        // Armory: Weapons, armor
        // Tavern: Party members
        System.out.println();
        return scanner.nextInt();
    }
    public String getOptions(){
        return "Tavern(1), Armory(2), Wizards Hut(3), Leave(0)";
    }

}
