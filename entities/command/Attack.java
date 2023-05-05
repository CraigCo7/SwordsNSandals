package entities.command;

import entities.Gladiator;

public class Attack implements Command {

    private Gladiator gladiator;

    public Attack(Gladiator gladiator) {
        this.gladiator = gladiator;
    }

    public void execute() {
        gladiator.attack();
    }

}
