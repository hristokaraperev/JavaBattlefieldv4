package composite;

import combatants.abstractions.Combatant;
import combatants.humans.General;
import composite.abstractions.Unit;

import java.util.List;

public class Army extends Unit {
    // this class will hold the elements of the composition
    // and will implement the operations in the unit component
    private Combatant general;





    private List<Unit> brigades;
    private double armyMorale = 1;

    public List<Unit> getBrigades() {
        return brigades;
    }
    public Combatant getGeneral() {
        return general;
    }

    public void setBrigades(List<Unit> brigades) {
        this.brigades = brigades;
    }
    public void setGeneral(Combatant general) {
        this.general = general;
    }
}
