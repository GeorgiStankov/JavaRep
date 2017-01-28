package week08_DungeonAndZombies;

import java.util.Scanner;

public class DungeonMain {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Hero hero=new Hero("Jorko","The Mad King",100,100,2);
		Weapons w=new Weapons("The Axe of Destiny",20);
		hero.equip(w);
		System.out.println(hero.knownAs());
		Dungeon dg=new Dungeon();
		dg.spawn(hero);
		dg.printMap();
		String move="";
		while(hero.isAlive()){
			
			move=sc.next();
			dg.moveHero(move);
			dg.printMap();
			
		}
		sc.close();
	}

}
