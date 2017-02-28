package bg.jwd.intern.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import bg.jwd.intern.entities.OutgoingCall;

@Repository
public class OutgoingCallsDaoImpl implements OugoingCallsDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public boolean callNumber(OutgoingCall call) {
		entityManager.merge(call);
		return true;
	}

	@Override
	@Transactional
	public List<OutgoingCall> outgoingCallsReg() {
		TypedQuery<OutgoingCall> query = entityManager.createQuery("SELECT s FROM OutgoingCall s", OutgoingCall.class);
		return query.getResultList();
	}

}
