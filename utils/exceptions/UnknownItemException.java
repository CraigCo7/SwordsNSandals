package utils.exceptions;


public class UnknownItemException extends Exception {
    public UnknownItemException() {
        super("You do not own this item!");
    }
}
