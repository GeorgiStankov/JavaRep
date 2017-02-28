package bg.OOP.OpinionPoll;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class Test {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		TreeMap<String,Integer> tree = new TreeMap<>();
		for (int i = 0; i < n; i++) {
			String[] pair = reader.readLine().split(" ");
			String name = pair[0];
			int age = Integer.parseInt(pair[1]);

			if (age > 30) {
				Person person = new Person(name, age);
				if(!tree.containsKey(name)){
					tree.put(name,age);	
				}
				
				
			} else
				continue;
		}
		
		for (Entry<String,Integer> c : tree.entrySet()) {
			System.out.println(c.getKey()+" - "+c.getValue());
		}

	}

}
