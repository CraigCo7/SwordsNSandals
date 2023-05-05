package entities.items;

public class Armor extends Equipment {
    private int baseArmor;
    private int armor;
    private String description;

    public Armor(EquipmentName equipmentName, int level) {
        super(EquipmentType.ARMOR, equipmentName, level);
        this.baseArmor = instantiateBaseArmor(equipmentName);
        this.armor = instantiateArmor();
        this.description = instantiateDescription(equipmentName);
    }

    private int instantiateBaseArmor(EquipmentName equipmentName) {
        if (equipmentName == EquipmentName.HELMET) {
            return 4;
        } else if (equipmentName == EquipmentName.CHESTPLATE) {
            return 16;
        } else if (equipmentName == EquipmentName.BRACERS) {
            return 4;
        } else if (equipmentName == EquipmentName.GREAVES) {
            return 6;
        } else {
            return 10;
        }
    }

    private int instantiateArmor() {
        return baseArmor * this.getLevel();
    }

    private String instantiateDescription(EquipmentName equipmentName) {
        if (equipmentName == EquipmentName.HELMET) {
            return "HELMET";
        } else if (equipmentName == EquipmentName.CHESTPLATE) {
            return "CHESTPLATE";
        } else if (equipmentName == EquipmentName.BRACERS) {
            return "BRACERS";
        } else if (equipmentName == EquipmentName.GREAVES) {
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
}

