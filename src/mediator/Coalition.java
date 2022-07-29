package mediator;

import composite.abstractions.Unit;
import factories.CoalitionBuilder;
import visitor.ElementInterface;

import java.util.List;
import java.util.Map;

public class Coalition {

    private List<Unit> armies;
    public Coalition() {
        CoalitionBuilder coalitionBuilder = new CoalitionBuilder();
        this.armies = coalitionBuilder.createCoalition();
    }

    public List<Unit> getArmies() {
        return armies;
    }

    public void setArmies(List<Unit> armies) {
        this.armies = armies;
    }

    @Override
    public String toString() {
        String message = "";
        for (Unit army : armies) {
            message += army.toString() + "\n";
        }
        return message;
    }
}
