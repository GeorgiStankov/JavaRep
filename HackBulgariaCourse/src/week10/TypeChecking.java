package week10;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TypeChecking {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Type> list = new LinkedList<>();
		while (sc.hasNextLine()) {
			String function = sc.nextLine();
			if (function.equals("")) {
				break;
			}

			String[] parts = function.trim().split(" ");
			String name = parts[0];
			String take = parts[2];
			String returns = parts[4];
			Type tp = new Type(name, take, returns);
			list.add(tp);
		}
		String composition = sc.nextLine();
		String[] compositionPart = composition.replaceAll("\\s+","").split("\\.");
		int length=compositionPart.length-1;
		String returnType = "";
		boolean isValid=false;
		for (int i = length; i >= 0; i--) {
			for (Type item : list) {
				if (compositionPart[i].equals(item.getName()) && i == length) {
					returnType = item.getReturns();		
					isValid=true;
					continue;
					
				} 
				else if (compositionPart[i].equals(item.getName()) && i!=length) {
					if (item.getTakes().equals(returnType)) {
						returnType = item.getReturns();
						isValid=true;
					} else {
						System.out.println("This is not a valid composition");
						isValid=false;
						break;
					}
				}
			}
		}
		
		if(isValid){
		System.out.println("everything's OK and this is a valid composition.");	
		}
		sc.close();

	}



}
