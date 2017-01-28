package week08_DungeonAndZombies;

import java.util.Scanner;

public class Dungeon {
	Hero hero;
	int heroX = 0;
	int heroY = 0;

	String[][] dungeon = { { "S", ".", "#", "#", ".", ".", ".", ".", ".", "T" },
			{ "#", "T", "#", "#", ".", ".", "#", "#", "#", "." }, { "#", ".", "#", "#", "#", "E", "#", "#", "#", "E" },
			{ "#", ".", "E", ".", ".", ".", "#", "#", "#", "." },
			{ "#", "#", "#", "T", "#", "#", "#", "#", "#", "G" } };

	public void printMap() {
		for (int row = 0; row < 5; row++) {
			for (int col = 0; col < 10; col++) {
				System.out.print(dungeon[row][col]);
			}
			System.out.println();
		}
	}

	public boolean spawn(Hero hero1) {
		boolean isSpawn = false;
		for (int row = 0; row < 5; row++) {
			for (int col = 0; col < 10; col++) {
				if (dungeon[row][col].equals("S")) {
					dungeon[row][col] = "H";
					heroX = row;
					heroY = col;
					hero = hero1;
					isSpawn = true;
				} else
					isSpawn = false;
			}
		}
		return isSpawn;
	}

	public void moveHero(String direction) {
		String temp = "";
		try {
			switch (direction) {
			case "up":
				temp = dungeon[heroX - 1][heroY];
				moving(temp, -1, 0);

				break;
			case "down":
				temp = dungeon[heroX + 1][heroY];
				moving(temp, 1, 0);
				break;
			case "left":
				temp = dungeon[heroX][heroY - 1];
				moving(temp, 0, -1);
				break;
			case "right":
				temp = dungeon[heroX][heroY + 1];
				moving(temp, 0, 1);
				break;
			}
			hero.mana += 2;
		} catch (IndexOutOfBoundsException ex) {
			System.out.println("Wrong direction");
		}

	}

	private void moving(String temp, int x, int y) throws IndexOutOfBoundsException {
		String tyle = temp;

		switch (tyle) {
		case "#":
			System.out.println("Obstacle");
			break;
		case "E":
			fight();
			if (hero.isAlive()) {
				dungeon[heroX + x][heroY + y] = ".";
			}
			break;

		case "T":
			pickTresure();
			dungeon[heroX + x][heroY + y] = "H";
			dungeon[heroX][heroY] = ".";
			heroX = heroX + x;
			heroY = heroY + y;
			break;
		case "G":
			dungeon[heroX + x][heroY + y] = "H";
			dungeon[heroX][heroY] = ".";
			heroX = heroX + x;
			heroY = heroY + y;
			System.out.println("Level Completed");

		default:
			dungeon[heroX + x][heroY + y] = "H";
			dungeon[heroX][heroY] = temp;
			heroX = heroX + x;
			heroY = heroY + y;
			break;
		}

	}

	private void fight() {
		Enemy enemy = new Enemy(100, 100, 10);
		Scanner sc = new Scanner(System.in);
		while (hero.health > 0 && enemy.health > 0) {
			
			System.out.println("Choose between weapon and spell: ");
			String choice = sc.next();
			System.out.println(hero.knownAs() + " attacked the enemy with " + hero.attack(choice) + " damage.");
			enemy.takeDamage(hero.attack(choice));
			System.out.println("Enemy atacked " + hero.knownAs() + " with " + enemy.attack());
			hero.takeDamage(enemy.attack());
			System.out
					.println(hero.knownAs() + " is " + hero.getHealth() + " hp.Zombie health is " + enemy.getHealth());
		
		}
		if (!enemy.isAlive()) {
			System.out.println("Zombie is dead." + hero.knownAs() + " won the battle.");
		} else {
			System.out.println("Hero is dead.");
			System.out.println("Game over.");
		}
		
		

	}

	private void pickTresure() {
		Treasure feelingLucky = new Treasure();
		hero.equip(feelingLucky.weapon);
		hero.learn(feelingLucky.spell);
		hero.drinkPotion(feelingLucky.potion);
		System.out.println("Found Tresure.Hero equip with " + feelingLucky.toString());
	}

}
