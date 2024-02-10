package rpg_game;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Round {
    private List<? extends Enemy> availableEnemies = new ArrayList<>();
    private List<Enemy> currentRound = new ArrayList<>();
    public List<Enemy> getCurrent() {
        return currentRound;
    }

    private int roundLength = 5;
    private Scanner scanner = new Scanner(System.in);

    public void refresh(int playerLevel) {
        setAvailableEnemies(playerLevel);
        populateCurrentRound();
    }

    public void nextEnemy(Player player, int index){

        Enemy currentEnemy = this.currentRound.get(index);
        System.out.println("You encountered a " + currentEnemy.getName() + "!");

        handleBattleLogic(player, currentEnemy);
    }

    private void handleBattleLogic(Player player, Enemy enemy){
        while(true){
            System.out.println("What do you do?");
            int choice = this.showBattleOptions(player);

            if (choice == 0) return;

            if (choice == 1){
                player.attack(enemy);
            }

            //Enemy shouldn't be able to attack if it is dead.
            if (!enemy.isAlive()) break;
            enemy.attack(player);
            if (!player.getIsAlive()) return;
            showRoundStats(player, enemy);
        }
        player.getRewards(enemy);
    }
    private void showRoundStats(Player player, Enemy enemy) {
        System.out.println(
                player.getName() +
                " HP: " +
                player.getMaxHealth() +
                "/" +
                player.getHealth()
                );
        System.out.println(
                enemy.getName() +
                " HP: " +
                enemy.getMaxHealth() +
                "/" +
                enemy.getHealth()
                );
    }

    public int showBattleOptions(Player player){
        while(true){
            System.out.println("Attack(1), Check Inventory(2), Run Away(0)");
            int choice = scanner.nextInt();
            if (choice == 1 || choice == 0) return choice;
            if (choice == 2){
                //show inventory
            }

        }
    }
    private void setAvailableEnemies(int playerLevel) {
        if (playerLevel < 10) {
            availableEnemies = createEasyEnemies(playerLevel);
        } else {
            availableEnemies = createNormalEnemies(playerLevel);
        }
    }

    private List<? extends Enemy> createEasyEnemies(int playerLevel) {
        return List.of(
                new Ghost(playerLevel),
                new Slime(playerLevel),
                new Skeleton(playerLevel)
                );
    }

    private List<? extends Enemy> createNormalEnemies(int playerLevel) {
        // Create and return a list of normal enemies
        return List.of(
                new Orc(playerLevel),
                new Troll(playerLevel),
                new FireSpirit(playerLevel)
                );
    }

    private void populateCurrentRound() {
        Random random = new Random();
        this.currentRound.removeAll(currentRound);
        for (int i = 0; i < roundLength; i++) {
            int randomIndex = random.nextInt(availableEnemies.size());
            Enemy enemy = availableEnemies.get(randomIndex);
            currentRound.add(enemy);
        }
    }
}
