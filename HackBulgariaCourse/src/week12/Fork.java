package week12;

import java.util.concurrent.Semaphore;

public class Fork extends Semaphore {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Fork() {
        super(1, true);
    }
}