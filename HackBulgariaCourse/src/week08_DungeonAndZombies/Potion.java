package week08_DungeonAndZombies;

public class Potion {
	int healAmount;

	public Potion(int healAmount) {
		this.healAmount = healAmount;
	}

	public int getHealAmount() {
		return healAmount;
	}


	public String toString() {
		return "a potion that restores " + getHealAmount() + " hp and mp!";
	}
}