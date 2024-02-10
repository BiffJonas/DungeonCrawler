package rpg_game;
import java.util.Scanner;

public interface Interactive{
    public Scanner scanner = new Scanner(System.in);

    public abstract String getOptions();

    default int showChoices(){
        System.out.println(getOptions());
        return scanner.nextInt();
    }
}
