package week08_DungeonAndZombies;

public class Weapons {
	String name;
	int damage;

	public Weapons(String name, int damage) {
		this.name = name;
		this.damage = damage;
	}
	public String toString(){
		return name +" with "+ damage+" damage";
	}
}
