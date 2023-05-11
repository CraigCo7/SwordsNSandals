package entities.command;

import entities.Gladiator;
import entities.Player;

public class Defend implements Command {

    private Gladiator player;
    private Gladiator gladiator;

    public Defend(Gladiator player, Gladiator gladiator) {
        this.player = player;
        this.gladiator = gladiator;
    }

    public void execute() {
        player.defend(gladiator);
    }

}
