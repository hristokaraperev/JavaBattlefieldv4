package visitor;

import combatants.abstractions.Human;
import composite.Army;
import composite.Coalition;
import composite.abstractions.Unit;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class BattleLine {

    public boolean visit(Coalition attacker, Coalition defender) {
        if (attacker.getArmies().isEmpty() || defender.getArmies().isEmpty()) {
            return true;
        }

        if (attacker.getArmies().stream().anyMatch(unit -> ((Human) ((Army) unit).getGeneral()).getHealthPoints() <= 0) ||
                defender.getArmies().stream().anyMatch(unit -> ((Human) ((Army) unit).getGeneral()).getHealthPoints() <= 0)) {
            return true;
        }

        Random rng = new Random();

        List<Unit> attackingArmies = attacker.getArmies();

        Iterator<Unit> defenderArmiesIterator = defender.getArmies().iterator();

        while (defenderArmiesIterator.hasNext()) {
            Unit nextArmy = defenderArmiesIterator.next();
            if (((Army) nextArmy).getBrigades().isEmpty()) {
                continue;
            }

            int indexOfAttackingArmy = rng.nextInt(attackingArmies.size());

            nextArmy.isGettingEngagedBy(attackingArmies.get(indexOfAttackingArmy), ((Army) nextArmy).getGeneral());

            if (((Human) ((Army) nextArmy).getGeneral()).getHealthPoints() <= 0) {
                return true;
            }
        }

        List<Unit> updatedDefenderArmies = defender.getArmies().stream().filter(unit -> !((Army) unit).getBrigades().isEmpty()).toList();

        defender.setArmies(updatedDefenderArmies);


        return false;
    }
}
