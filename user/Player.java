package user;

public class Player extends Gladiator {
    private static Player player;
    private static Storage storage;
    private String name;
    private int experience;
    private int level;


    private Player(String name, Builder builder) {
        super(builder);
        this.name = name;

        public static class Builder {
    }
}
