package user;
import java.util.LinkedList;
import java.util.List;

public class Backpack {
    private static List<Equipment> equipment = new LinkedList<Equipment>();

    protected Backpack() {
    }

    public static Equipment newItem(String name) {
        Equipment item = new Equipment(name);
        equipment.add(item);
        return item;
    }

    public static List<Equipment> backpack() {
        return Backpack.equipment;
    }

    // public String getTitle() {
    //     return this.title;
    // }

    // public String toString() {
    //     return this.getTitle();
    // }
}
