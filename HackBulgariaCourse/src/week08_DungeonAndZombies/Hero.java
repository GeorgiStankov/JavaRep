package week08_DungeonAndZombies;

public class Hero {
	String name;
	String title;
	int health;
	int mana;
	int manaRegenRate;
	int damageWeapon;
	int damageSpell;
	int manaSpell;
	int maxHealth;

	public Hero(String name, String title, int health, int mana, int manaRegenRate) {
		this.name = name;
		this.title = title;
		this.health = health;
		this.mana = mana;
		this.manaRegenRate = manaRegenRate;
		this.maxHealth = health;
	}

	public String knownAs() {

		return this.name + " " + this.title;
	}

	public int getDamage(){
		return this.damageWeapon;
	}
	public int getHealth() {

		return this.health;
	}

	public int getMana() {

		return this.mana;
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

	private void useMana(int amount) {
		this.mana -= amount;
	}

	public void takeDamage(int damagePoints) {
		if (this.health - damagePoints > 0) {
			this.health = this.health - damagePoints;
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

	public void equip(Weapons weapon) {
		this.damageWeapon = weapon.damage;
	}

	public void learn(Spell sp) {
		this.damageSpell = sp.damage;
	}

	public void drinkPotion(Potion p) {
		this.health += p.healAmount;
	}

	public int attack(String spWn) {
		int damage = 0;
		if (spWn.equals("weapon")) {
			damage = this.damageWeapon;
		} else if (spWn.equals("spell")) {
			damage = this.damageSpell;
			useMana(manaSpell);

		}
		return damage;
	}

}
