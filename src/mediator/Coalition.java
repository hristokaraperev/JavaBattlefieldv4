package mediator;

import composite.abstractions.Unit;
import factories.CoalitionBuilder;

import java.util.List;
import java.util.Map;

public class Coalition {
    private Map<Unit, List<Unit>> armiesAndTheirBrigades;

    public Coalition() {
        CoalitionBuilder coalitionBuilder = new CoalitionBuilder();
        this.armiesAndTheirBrigades = coalitionBuilder.createCoalition();
    }
}
