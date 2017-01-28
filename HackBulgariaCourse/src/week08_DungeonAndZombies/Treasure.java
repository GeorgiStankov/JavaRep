package week08_DungeonAndZombies;

import java.util.Random;

public class Treasure {
	Weapons weapon;
	Spell spell;
	Potion potion;

	public Treasure() {
		Weapons[] armory = { new Weapons("Silver lance", 40), new Weapons("Silver bow", 40),
				new Weapons("Silver sword", 40) };
		Spell[] library = { new Spell("Fire", 45, 45, 2), new Spell("Nosferatu", 30, 45, 2),
				new Spell("Shine", 40, 40, 2) };
		Potion[] potions = { new Potion(25), new Potion(50), new Potion(100) };

		Random rand = new Random();
		int index = rand.nextInt(3);
		setWeapon(armory[index]);
		setSpell(library[index]);
		setPotion(potions[index]);

	}

	public Weapons getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapons weapon) {
		this.weapon = weapon;
	}

	public Spell getSpell() {
		return spell;
	}

	public void setSpell(Spell spell) {
		this.spell = spell;
	}

	public Potion getPotion() {
		return potion;
	}

	public void setPotion(Potion potion) {
		this.potion = potion;
	}

	public String toString() {
		return weapon.toString() + " " + spell.toString();
	}

}
