package utils;
public class NotEnoughAvailableStatsException extends Exception {
    public NotEnoughAvailableStatsException(String available) {
        super("You do not have enough available stats to add these points. You only have " + available + " points at the moment");
    }
}
