package bg.jwd.intern.services;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bg.jwd.intern.dao.OugoingCallsDao;
import bg.jwd.intern.dao.PhonebookDao;
import bg.jwd.intern.entities.OutgoingCall;
import bg.jwd.intern.entities.Phonebook;

@Service
public class PhonebookImpl implements PhonebookService {

	

	@Autowired
	private PhonebookDao phonebookDao;
	@Autowired
	private OugoingCallsDao outgoingCalls;

	@Override
	public boolean adding(Phonebook phonebook) {
		phonebookDao.Adding(phonebook);
		return true;
	}

	@Override
	public List<Phonebook> phonebooks() {
		return phonebookDao.getPhonebook();
	}


	@Override
	public boolean removing(String name) {
		phonebookDao.Removing(name);
		return true;
	}
	
	 @Override
	 public boolean textFilePhoneBook(String str) {
	 boolean read = false;
	 BufferedReader br = null;
	
	 try {
	 br = new BufferedReader(new FileReader(str));
	 int size, people;
	 String data = null;
	 String[] pair = null;
	 StringBuffer stringBuffer = new StringBuffer("");
	 while ((data = br.readLine()) != null) {
	 stringBuffer.append(data + " ");
	 }
	
	 pair = stringBuffer.toString().split(" ");
	 size = pair.length;
	 people = size / 2;
	 for (int i = 0; i < people; i++) {
	 String name = pair[i * 2];
	 String number = getFirstLetters(pair[(i * 2) + 1]);
	
	 if (number != null) {
	 Phonebook ph = new Phonebook();
	 ph.setName(name);
	 ph.setNumber(number);
		phonebookDao.Adding(ph);
	 read = true;
	 }
	
	 }
	 br.close();
	
	 } catch (FileNotFoundException e) {
	 // TODO Auto-generated catch block
	 e.printStackTrace();
	 } catch (IOException e) {
	 // TODO Auto-generated catch block
	 e.printStackTrace();
	 }
	 return read;
	 }

	public String getFirstLetters(String number) {
		Pattern pat = Pattern.compile("(^(\\+359)|^(0)|^(00359))((87)|(88)|(89))[^0-1]{1}[0-9]{6}$");
		Matcher matcher = pat.matcher(number);
		if (matcher.find()) {
			if (number.substring(0, 5).equals("00359")) {
				number = number.replace("00359", "+359");
			} else if (number.charAt(0) == '0') {
				number = number.replace("0", "+359");
			}

			return number;

		}
		return null;

	}
	@Override
	public List<OutgoingCall> outgoingCalls() {
		// TODO Auto-generated method stub
		return outgoingCalls.outgoingCallsReg() ;
	}


	 @Override
	 public boolean callNumber(OutgoingCall call) {
		 outgoingCalls.callNumber(call);
//	 boolean called = false;
//	 for (Phonebook item : Phonebooks) {
//	
//	 if (item.getName().equals(phonebook.getName()) &&
//	 item.getNumber().equals(phonebook.getNumber())) {
//	 if (!outgoingCalls.containsKey(item)) {
//	 outgoingCalls.put(item, 0);
//	 }
//	
//	 outgoingCalls.put(item, outgoingCalls.get(item) + 1);
//	 called = true;
//	 outgoingCalls = sortByComparator(outgoingCalls);
//	 break;
//	
//	 } else
//	 called = false;
//	 }
//	
	 return true;
	 }
	//
	// public HashMap<Phonebook, Integer> sortByComparator(HashMap<Phonebook,
	// Integer> unsortMap) {
	//
	// // Convert Map to List
	// List<Map.Entry<Phonebook, Integer>> list = new
	// LinkedList<Map.Entry<Phonebook, Integer>>(unsortMap.entrySet());
	//
	// // Sort list with comparator, to compare the Map values
	// Collections.sort(list, new Comparator<Map.Entry<Phonebook, Integer>>() {
	// public int compare(Map.Entry<Phonebook, Integer> o1, Map.Entry<Phonebook,
	// Integer> o2) {
	// return (o2.getValue()).compareTo(o1.getValue());
	// }
	// });
	//
	// // Convert sorted map back to a Map
	// HashMap<Phonebook, Integer> sortedMap = new LinkedHashMap<Phonebook,
	// Integer>();
	// for (Iterator<Map.Entry<Phonebook, Integer>> it = list.iterator();
	// it.hasNext();) {
	// Map.Entry<Phonebook, Integer> entry = it.next();
	// sortedMap.put(entry.getKey(), entry.getValue());
	// }
	// return sortedMap;
	// }


}
