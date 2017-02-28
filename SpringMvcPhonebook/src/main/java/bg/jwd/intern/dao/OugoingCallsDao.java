package bg.jwd.intern.dao;

import java.util.List;

import bg.jwd.intern.entities.OutgoingCall;

public interface OugoingCallsDao {

	boolean callNumber(OutgoingCall call);

	List<OutgoingCall> outgoingCallsReg();
	
}
