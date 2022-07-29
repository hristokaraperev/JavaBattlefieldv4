package composite;

import composite.abstractions.Unit;
import factories.CoalitionBuilder;

import java.util.List;

public class Coalition {

    // coalition game unit
    private List<Unit> armies;

    // builds coalition
    public Coalition(int armies, int brigades, int humans) {
        CoalitionBuilder coalitionBuilder = new CoalitionBuilder(armies, brigades, humans);
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
