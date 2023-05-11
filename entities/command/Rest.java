package entities.command;

import entities.Gladiator;

public class Rest implements Command {

    private Gladiator player;
    private Gladiator opponent;

    public Rest(Gladiator player, Gladiator opponent) {
        this.player = player;
        this.opponent = opponent;
    }

    public void execute() {
        player.rest(opponent);
    }

}
