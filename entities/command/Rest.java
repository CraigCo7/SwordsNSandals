package entities.command;

import entities.Gladiator;

public class Rest implements Command {

    private Gladiator gladiator;

    public Rest(Gladiator gladiator) {
        this.gladiator = gladiator;
    }

    public void execute() {
        gladiator.rest();
    }

}
