package composite;

import combatants.abstractions.Combatant;
import composite.abstractions.Unit;

import java.util.List;

public class Brigade extends Unit {
    // building block of the army
    // it will define the behaviour of the elements in the composition
    private Combatant warMachine;
    private List<Combatant> humans;

    public Combatant getWarMachine() {
        return warMachine;
    }

    public void setWarMachine(Combatant warMachine) {
        this.warMachine = warMachine;
    }

    public List<Combatant> getHumans() {
        return humans;
    }

    public void setHumans(List<Combatant> humans) {
        this.humans = humans;
    }
}
