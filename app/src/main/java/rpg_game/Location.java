package rpg_game;
public abstract class Location {
    protected int currentLevel;

    protected void setLevel(int level){
        this.currentLevel = level;
    }
    public int getLevel() {
		return currentLevel;
	}
	protected String getName(){
        return getClass().getSimpleName();
    }
}
