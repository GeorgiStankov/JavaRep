package week08;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int zombiesCount = sc.nextInt();
		int zombiesHealth = sc.nextInt();
		int count = 0;

		
		HashMap<String, Weapon> weapons=new HashMap<String,Weapon>();
		weapons.put("axe",new Axe());
		weapons.put("shotgun", new Shotgun());
		weapons.put("sword", new Sword());
		Weapon weapon=weapons.get(sc.next());
		
		for (int i = 0; i < zombiesCount; i++) {
			int oneZombieHealth=zombiesHealth;
			while(oneZombieHealth>0){
				oneZombieHealth=oneZombieHealth-weapon.hit();
				count++;
			}
			
		}
		System.out.println(count);
		sc.close();
	}
}
