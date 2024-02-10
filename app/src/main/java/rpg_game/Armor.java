package rpg_game;

public class Armor {

    protected ChestPlate chestPlate = new ChestPlate(0);
    protected Leggings leggings= new Leggings(0);
    protected Boots boots = new Boots(0);
    protected int armorScore = getArmorScore();
    public int getArmorScore() {
        return (
                chestPlate.getArmorValue() +
                boots.getArmorValue() +
                leggings.getArmorValue()
               );
    }
    public void equipChestPlate(ChestPlate newChestPlate){
        chestPlate = newChestPlate;
    }
    public void equipLeggings(Leggings newLeggings){
        leggings = newLeggings;
    }
    public void equipBoots(Boots newBoots){
        boots = newBoots;
    }

        
    public int updateArmorScore;
    
}
