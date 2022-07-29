package composite.abstractions;

import combatants.abstractions.Combatant;

public abstract class Unit {
    public abstract int isGettingEngagedBy(Unit unit, Combatant general);

}
