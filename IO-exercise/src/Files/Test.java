package Files;

import java.io.IOException;
public class Test {
	public static void main(String[] args) {
		Person[] personList = FileActions.readPersonsFromFile();
		try {
			FileActions.writePersonToFile(personList);
		} catch (IOException e) {
			System.out.println("File Fatal Error");
		}
		
	}
}