package user.items;

import utils.exceptions.UnknownWeaponException;

public class Weapon extends Equipment implements Cloneable {

  private int damage;
  private int weight;

  private Weapon(WeaponType type) throws UnknownWeaponException {
    super(type);
    if (type == WeaponType.SWORD) {
      this.damage = 10;
      this.weight = 10;
    } else if (type == WeaponType.AXE) {
      this.damage = 15;
      this.weight = 20;
    } else if (type == WeaponType.SPEAR) {
      this.damage = 10;
      this.weight = 15;
    } else if (type == WeaponType.BAGGUETE) {
      this.damage = 15;
      this.weight = 3;
    } else if (type == WeaponType.HYDROFLASK) {
      this.damage = 20;
      this.weight = 30;
    } else if (type == WeaponType.RIZZ) {
      this.damage = 20;
      this.weight = 0;
    } else if (type == WeaponType.DADS_BELT) {
      this.damage = 20;
      this.weight = 5;
    } else if (type == WeaponType.MOMS_SLIPPER) {
      this.damage = 3;
    } else {
      throw new UnknownWeaponException(type.toString());
    }
  }

  public static Weapon makeWeapon(WeaponType type) throws UnknownWeaponException {
    Weapon weapon;
    switch (type) {
      case SWORD:
        weapon = new Weapon(WeaponType.SWORD);
        return weapon;
      case AXE:
        weapon = new Weapon(WeaponType.AXE);
        return weapon;
      case SPEAR:
        weapon = new Weapon(WeaponType.SPEAR);
        return weapon;
      default:
        throw new UnknownWeaponException(type.toString());
    }
  }

  @Override
  public Weapon clone() throws CloneNotSupportedException {
    return (Weapon) super.clone();
  }
}
