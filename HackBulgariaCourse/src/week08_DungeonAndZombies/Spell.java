package week08_DungeonAndZombies;

public class Spell {
	String name;
	int damage;
	int manaCost;
	int castRange;
	
	public Spell(String name,int damage,int manaCost,int castRange){
		this.name=name;
		this.damage=damage;
		this.manaCost=manaCost;
		this.castRange=castRange;
		
	}
	
	public String toString(){
		return name+" with "+damage+" damage "+manaCost+" mana cost "+castRange+" cast range.";
	}
	
	
}
