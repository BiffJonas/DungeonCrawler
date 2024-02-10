package rpg_game;

public class Blacksmith extends Seller {

    public Blacksmith(Store store){
        super(store);
    }
    public void greetPlayer(){
        System.out.println(getName() + ": Looking to protect yourself, or deal some damage?");
    }
        

}
