package rpg_game;

public class Armory extends Store {

    public String getOptions(){
        return "Browse wares(0), upgrade equipment(1), Leave(3)";
    }
    

    protected void setSeller(){
        this.seller = new Blacksmith(this);
    }
}
