package week08_DungeonAndZombies;

public class Enemy {
	int health;
	int mana;
	int damage;
	int maxHealth;

	public Enemy(int health, int mana, int damage) {
		this.health = health;
		this.mana = mana;
		this.damage = damage;
		this.maxHealth = health;
	}

	public int getHealth() {

		return this.health;
	}

	public boolean isAlive() {
		if (this.health <= 0) {
			return false;
		}
		return true;
	}

	public boolean canCast() {
		// TODO Auto-generated method stub
		return false;
	}

	public void takeDamage(int damagePoints) {
		if (this.health - damagePoints > 0) {
			this.health = this.health - damagePoints;
		}
		else{
			this.health=0;
		}

	}

	public void takeHealing(int healingPoints) {
		if (this.health != 0 && (this.health + healingPoints <= maxHealth)) {
			this.health = this.health + healingPoints;
		}

	}

	public void takeMana(int manaPoints) {
		this.mana += manaPoints;

	}

	public int attack() {

		return this.damage;
	}

}
