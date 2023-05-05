package entities.command;

import entities.Gladiator;

public class Defend implements Command {

    private Gladiator gladiator;

    public Defend(Gladiator gladiator) {
        this.gladiator = gladiator;
    }

    public void execute() {
        gladiator.defend();
    }

}
