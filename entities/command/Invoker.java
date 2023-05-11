package entities.command;

import java.util.*;

public class Invoker {
    private List<Command> subsistence = new ArrayList<>();

    public void addActivity(Command c) {
        subsistence.add(c);
    }

    public void performActivities() {
        for (Command c : subsistence) {
            c.execute();
            try {
                Thread.sleep(900);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


