package user.items;

public class Weapon extends Equipment {
    private int baseDamage;
    private int minDamage;
    private int maxDamage;
    private int weight;
    private double lvlUpMin;
    private double lvlUpMax;
    private String description;

    public Weapon(EquipmentName equipmentName, int level) {
        super(EquipmentType.WEAPON, equipmentName, level);
        this.rarity = instantiateRarity(equipmentName);
        this.weight = instantiateWeight(equipmentName);
        this.baseDamage = instantiateBaseDamage(equipmentName);
        this.lvlUpMin = instantiateLvlMin(equipmentName);
        this.lvlUpMax = instantiateLvlMax(equipmentName);
        this.minDamage = instantiateMinDamage();
        this.maxDamage = instantiateMaxDamage();
        this.description = instantiateDescription(equipmentName);

    }

    private Rarity instantiateRarity(EquipmentName equipmentName) {
        if (equipmentName == EquipmentName.RIZZ) {
            return Rarity.LEGENDARY;
        } else if (equipmentName == EquipmentName.BAGUETTE
                || equipmentName == EquipmentName.HYDROFLASK
                || equipmentName == EquipmentName.DADBELT
                || equipmentName == EquipmentName.MOMSLIPPER) {
            return Rarity.RARE;
        } else {
            return Rarity.COMMON;
        }
    }

    private int instantiateWeight(EquipmentName equipmentName) {
        if (equipmentName == EquipmentName.SWORD) {
            return 8;
        } else if (equipmentName == EquipmentName.AXE) {
            return 20;
        } else if (equipmentName == EquipmentName.SPEAR) {
            return 15;
        } else if (equipmentName == EquipmentName.BAGUETTE) {
            return 3;
        } else if (equipmentName == EquipmentName.HYDROFLASK) {
            return 30;
        } else if (equipmentName == EquipmentName.DADBELT) {
            return 5;
        } else if (equipmentName == EquipmentName.MOMSLIPPER) {
            return 3;
        } else {
            return 0;
        }
    }

    private int instantiateBaseDamage(EquipmentName equipmentName) {
        if (equipmentName == EquipmentName.SWORD) {
            return 10;
        } else if (equipmentName == EquipmentName.AXE) {
            return 18;
        } else if (equipmentName == EquipmentName.SPEAR) {
            return 12;
        } else if (equipmentName == EquipmentName.BAGUETTE) {
            return 8;
        } else if (equipmentName == EquipmentName.HYDROFLASK) {
            return 25;
        } else if (equipmentName == EquipmentName.DADBELT) {
            return 18;
        } else if (equipmentName == EquipmentName.MOMSLIPPER) {
            return 12;
        } else {
            return 35;
        }
    }

    private double instantiateLvlMin(EquipmentName equipmentName) {
        if (equipmentName == EquipmentName.SWORD) {
            return 1.3;
        } else if (equipmentName == EquipmentName.AXE) {
            return 1.2;
        } else if (equipmentName == EquipmentName.SPEAR) {
            return 1.4;
        } else if (equipmentName == EquipmentName.BAGUETTE) {
            return 1.3;
        } else if (equipmentName == EquipmentName.HYDROFLASK) {
            return 1.2;
        } else if (equipmentName == EquipmentName.DADBELT) {
            return 1.1;
        } else if (equipmentName == EquipmentName.MOMSLIPPER) {
            return 1.1;
        } else {
            return 0;
        }
    }

    private double instantiateLvlMax(EquipmentName equipmentName) {
        if (equipmentName == EquipmentName.SWORD) {
            return 1.6;
        } else if (equipmentName == EquipmentName.AXE) {
            return 1.5;
        } else if (equipmentName == EquipmentName.SPEAR) {
            return 1.7;
        } else if (equipmentName == EquipmentName.BAGUETTE) {
            return 1.5;
        } else if (equipmentName == EquipmentName.HYDROFLASK) {
            return 1.5;
        } else if (equipmentName == EquipmentName.DADBELT) {
            return 1.2;
        } else if (equipmentName == EquipmentName.MOMSLIPPER) {
            return 1.2;
        } else {
            return 2.0;
        }
    }

    private String instantiateDescription(EquipmentName equipmentName) {
        if (equipmentName == EquipmentName.SWORD) {
            return "SWORD";
        } else if (equipmentName == EquipmentName.AXE) {
            return "AXE";
        } else if (equipmentName == EquipmentName.SPEAR) {
            return "SPEAR";
        } else if (equipmentName == EquipmentName.BAGUETTE) {
            return "BAGUETTE";
        } else if (equipmentName == EquipmentName.HYDROFLASK) {
            return "HYDROFLASK";
        } else if (equipmentName == EquipmentName.DADBELT) {
            return "DADBELT";
        } else if (equipmentName == EquipmentName.MOMSLIPPER) {
            return "MOMSLIPPER";
        } else {
            return "RIZZ";
        }
    }

    private int instantiateMinDamage() {
        return (int) Math.floor(baseDamage * this.getLevel() * lvlUpMin);
    }

    private int instantiateMaxDamage() {
        return (int) Math.floor(baseDamage * this.getLevel() * lvlUpMax);
    }

    public String getDescription() {
        return this.description;
    }


}
