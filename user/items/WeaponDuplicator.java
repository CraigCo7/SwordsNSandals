package user.items;

import utils.exceptions.UnknownWeaponException;

public class WeaponDuplicator {

  private Weapon sword;
  private Weapon axe;
  private Weapon spear;
  private Weapon bagguete;
  private Weapon hydroflask;
  private Weapon rizz;
  private Weapon dadsBelt;
  private Weapon momsSlipper;

  private static final WeaponDuplicator duplicator = new WeaponDuplicator();

  private WeaponDuplicator() {
    try {
      this.sword = Weapon.makeWeapon(WeaponType.SWORD);
      this.axe = Weapon.makeWeapon(WeaponType.AXE);
      this.spear = Weapon.makeWeapon(WeaponType.SPEAR);
      this.bagguete = Weapon.makeWeapon(WeaponType.BAGGUETE);
      this.hydroflask = Weapon.makeWeapon(WeaponType.HYDROFLASK);
      this.rizz = Weapon.makeWeapon(WeaponType.RIZZ);
      this.dadsBelt = Weapon.makeWeapon(WeaponType.DADS_BELT);
      this.momsSlipper = Weapon.makeWeapon(WeaponType.MOMS_SLIPPER);
    } catch (UnknownWeaponException e) {
      throw new RuntimeException("Unable to create Weapon prototypes", e);
    }
  }

  public static WeaponDuplicator makeWeaponDuplicator() {
    return duplicator;
  }

  public Weapon duplicateWeapon(WeaponType type) throws UnknownWeaponException {
    switch (type) {
      case SWORD:
        try {
          return sword.clone();
        } catch (CloneNotSupportedException e) {
          e.printStackTrace();
        }
      case AXE:
        try {
          return axe.clone();
        } catch (CloneNotSupportedException e) {
          e.printStackTrace();
        }
      case SPEAR:
        try {
          return spear.clone();
        } catch (CloneNotSupportedException e) {
          e.printStackTrace();
        }
      case BAGGUETE:
        try {
          return bagguete.clone();
        } catch (CloneNotSupportedException e) {
          e.printStackTrace();
        }
      case HYDROFLASK:
        try {
          return hydroflask.clone();
        } catch (CloneNotSupportedException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      case RIZZ:
        try {
          return rizz.clone();
        } catch (CloneNotSupportedException e) {
          e.printStackTrace();
        }
      case DADS_BELT:
        try {
          return dadsBelt.clone();
        } catch (CloneNotSupportedException e) {
          e.printStackTrace();
        }
      case MOMS_SLIPPER:
        try {
          return momsSlipper.clone();
        } catch (CloneNotSupportedException e) {
          e.printStackTrace();
        }
      default:
        throw new UnknownWeaponException(type.toString());
    }
  }
}
