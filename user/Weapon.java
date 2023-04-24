package user;
public class Weapon extends Equipment {

    private int damage;

    public Weapon(String name, int damage) {
        super(name);
        this.damage = damage;
    }
}
