package composite.abstractions;

import combatants.abstractions.Combatant;
import combatants.abstractions.Human;

public abstract class Unit {
    public abstract int isGettingEngagedBy(Unit unit, Combatant general);

}
