package entities.items;

public class Armor extends Equipment {
    private int baseArmor;
    private int armor;

    public Armor(ArmorType armorType, int level) {
        this.armorType = armorType;
        this.id = increaseCounter();
        this.baseArmor = instantiateBaseArmor(armorType);
        this.armor = instantiateArmor();
        this.description = instantiateDescription(armorType);
    }

    private int instantiateBaseArmor(ArmorType armorType) {
        if (armorType == ArmorType.HELMET) {
            return 4;
        } else if (armorType == ArmorType.CHESTPLATE) {
            return 16;
        } else if (armorType == ArmorType.BRACERS) {
            return 4;
        } else if (armorType == ArmorType.GREAVES) {
            return 6;
        } else {
            return 10;
        }
    }

    private int instantiateArmor() {
        return baseArmor * this.getLevel();
    }

    private String instantiateDescription(ArmorType armorType) {
        if (armorType == ArmorType.HELMET) {
            return "HELMET";
        } else if (armorType == ArmorType.CHESTPLATE) {
            return "CHESTPLATE";
        } else if (armorType == ArmorType.BRACERS) {
            return "BRACERS";
        } else if (armorType == ArmorType.GREAVES) {
            return "GREAVES";
        } else {
            return "SHIELD";
        }
    }

    public int getArmor() {
        return this.armor;
    }

    public String getDescription() {
        return this.description;
    }

    @Override
    public String toString() {
        return this.armorType.toString() + " - Level" + this.level;
    }
}

