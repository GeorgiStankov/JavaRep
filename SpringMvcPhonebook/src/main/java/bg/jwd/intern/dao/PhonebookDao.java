package bg.jwd.intern.dao;

import java.util.List;

import bg.jwd.intern.entities.Phonebook;

public interface PhonebookDao {
	List<Phonebook> getPhonebook();

	boolean Adding(Phonebook phonebook);
	public boolean Removing(String name);

}
