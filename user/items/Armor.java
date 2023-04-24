package user.items;

public class Armor extends Equipment {

  private ArmorType armorType;
  private int protection;

  public Armor(String name, ArmorType armorType, int protection) {
    super(name);
    this.armorType = armorType;
    this.protection = protection;
  }
}
