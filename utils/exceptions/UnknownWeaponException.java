package utils.exceptions;


public class UnknownWeaponException extends Exception {
    public UnknownWeaponException(String weapon) {
        super("Unknown Weapon Type: " + weapon + ".");
    }
}
