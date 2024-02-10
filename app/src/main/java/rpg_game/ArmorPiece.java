package rpg_game;

public abstract class ArmorPiece extends Item {
    protected int armorScore;
    public ArmorPiece(int armorScore){
        this.armorScore = armorScore;
    }

    public int getArmorValue() {
        return armorScore;
    }
    public void setArmorScore(int newArmorValue){

    }
    
}
