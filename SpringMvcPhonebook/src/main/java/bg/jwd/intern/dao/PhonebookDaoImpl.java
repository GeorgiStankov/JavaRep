package bg.jwd.intern.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import bg.jwd.intern.entities.Phonebook;

@Repository
public class PhonebookDaoImpl implements PhonebookDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Phonebook> getPhonebook() {
		TypedQuery<Phonebook> query = entityManager.createQuery("SELECT s FROM Phonebook s", Phonebook.class);
		return query.getResultList();
	}

	@Override
	@Transactional
	public boolean Adding(Phonebook phonebook) {

		entityManager.merge(phonebook);

		return true;
	}

	@Override
	@Transactional
	public boolean Removing(String name) {
		String sql = "SELECT p FROM Phonebook p WHERE name='" + name + "'";
		List<Phonebook> personToRemove = entityManager.createQuery(sql).getResultList();
		for (Phonebook m : personToRemove) {
			entityManager.remove(m);
		}
		return true;
	}

}
