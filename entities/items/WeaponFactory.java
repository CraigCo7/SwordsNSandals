package entities.items;

import java.util.HashMap;

public class WeaponFactory {
    private static final HashMap<String, Weapon> weapons = new HashMap<>();

    public static Weapon makeWeapon(String type, int level) {
        Weapon weapon = null;

        if (weapons.get(type) == null) {
            if (type.equals("sword")) {
                weapon = new Sword(level);
            } else if (type.equals("axe")) {
                weapon = new Axe(level);
            } else if (type.equals("spear")) {
                weapon = new Spear(level);
            } else if (type.equals("baguette")) {
                weapon = new Baguette(level);
            } else if (type.equals("hydroflask")) {
                weapon = new Hydroflask(level);
            } else if (type.equals("dadbelt")) {
                weapon = new DadBelt(level);
            } else if (type.equals("momslipper")) {
                weapon = new MomSlipper(level);
            } else if (type.equals("rizz")) {
                weapon = new Rizz(level);
            }
            weapons.put(type, weapon);
        }

        return weapons.get(type);
    }
}


