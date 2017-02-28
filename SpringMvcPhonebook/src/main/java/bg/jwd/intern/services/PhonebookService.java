package bg.jwd.intern.services;

import java.util.List;

import bg.jwd.intern.entities.OutgoingCall;
import bg.jwd.intern.entities.Phonebook;

public interface PhonebookService {

	List<OutgoingCall> outgoingCalls();

	List<Phonebook> phonebooks();

	public boolean adding(Phonebook phonebook);

	public boolean removing(String name);

	public boolean textFilePhoneBook(String str);

	public boolean callNumber(OutgoingCall call);
//
//	public HashMap<Phonebook, Integer> sortByComparator(HashMap<Phonebook, Integer> unsortMap);
}
