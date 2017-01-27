package bg.hackbulgaria.Exceptions;


/**
 * Created by georgiStankov on 27.01.16.
 */
public class InputException extends Exception {
    public InputException(String message) {
        super("input is not correct " + message);
    }
}