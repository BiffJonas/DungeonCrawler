package rpg_game;
public class Dungeon extends Location implements Interactive{
    private Round round = new Round();
    public void enter(Player player){

        System.out.println("Entering " + this.getName() + "...");
        while(player.getIsAlive()){
            this.setLevel(player.getLevel());
            round.refresh(this.getLevel());
            System.out.println("Enemies should be refreshed");
            //This is where the player fights through each enemy in the list
            for(int i = 0; i < round.getCurrent().size(); i++){

                this.round.nextEnemy(player, i);
                if(!player.getIsAlive()) return;
                int choice = this.showChoices();
                //player can choose to leave round early
                if (choice == 0 ) return;
            }

            int roundEndMove = getRoundEndDecision();
            if (roundEndMove == 0) return;
            else continue;
        }
    }
    private int getRoundEndDecision(){
        System.out.println("You finished this round of enemies");
        System.out.println("Would you like to continue?");
        System.out.println("Yes(1), No(0)");
        return scanner.nextInt();
    }

    public int showChoices(){
        while (true) {
            System.out.println("What would you like to do now?");
            System.out.println(getOptions());
            return scanner.nextInt();
        }
    }

    public String getOptions(){
        return "Go further into the " + this.getName() + "(1) Leave(0)";
    }
    public int showBattleOptions(){
        System.out.println("Attack(1), Heal(2), Run away(1)");
        return scanner.nextInt();
    }
}
