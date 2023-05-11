package entities.command;

import entities.Gladiator;

public class Attack implements Command {

    private Gladiator player;
    private Gladiator gladiator;

    public Attack(Gladiator player, Gladiator gladiator) {
        this.player = player;
        this.gladiator = gladiator;
    }

    public void execute() {
        player.attack(gladiator);
    }

}
