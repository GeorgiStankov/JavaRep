package Files;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class FileActions {
static public Person[] readPersonsFromFile() {
	Person[] personList = new Person[10];
	int size, persons;
	String data;
	String[] personData;
	BufferedReader br = null;
	try {
		br = new BufferedReader(new FileReader("data.txt"));
		data = br.readLine();
		personData = data.split("\\*");
		size = personData.length;
		persons = size / 5;
		System.out.println(persons);
		for (int i = 0; i < persons; i++) {
			Person p = new Person(personData[(i * 5) + 1], personData[(i * 5) + 2], personData[(i * 5) + 3],
					personData[(i * 5) + 4], personData[(i * 5) + 5]);
			personList[i] = p;
		}
	} catch (IOException ioex) {
		System.out.println("File error");
	} finally {
		try {
			if (br != null)
				br.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	return personList;
}
static public void writePersonToFile(Person[] personList) throws IOException {
	FileWriter file = null;
	for (int i = 0; personList[i] != null; i++) {
		if (personList[i].getAddress().indexOf("Bulgaria") != -1) {
			file = new FileWriter("Bulgarian.txt", true);
		} else {
			file = new FileWriter("Foreigner.txt", true);
		}
		BufferedWriter bw = new BufferedWriter(file);
		bw.write(personList[i].getFirstName() + "|" + personList[i].getLastName() + "|" + personList[i].getEGN()
				+ "|" + personList[i].getAddress() + "|" + personList[i].getUniversity() + "|"
				+ System.getProperty("line.separator"));
		bw.flush();
		file.close();
		bw.close();
	}
}
}