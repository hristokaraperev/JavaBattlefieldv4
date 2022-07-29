package visitor;

import combatants.abstractions.Human;
import composite.Army;
import composite.abstractions.Unit;
import mediator.Coalition;

import java.util.*;
import java.util.stream.Collectors;

public class BattleLine implements ElementInterface{

    @Override
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
            if (((Army)nextArmy).getBrigades().isEmpty()) {
                continue;
            }

            int indexOfAttackingArmy = rng.nextInt(attackingArmies.size());

            nextArmy.isGettingEngagedBy(attackingArmies.get(indexOfAttackingArmy), ((Army) nextArmy).getGeneral());

            if (((Human)((Army)nextArmy).getGeneral()).getHealthPoints() <= 0) {
                return true;
            }
        }

        List<Unit> updatedDefenderArmies = defender.getArmies().stream().filter(unit -> !((Army)unit).getBrigades().isEmpty()).toList();

        defender.setArmies(updatedDefenderArmies);


        return false;





        // first we check if the attackers have any remaining units
        // if no, we return true to Battle class and that class
        // registers the end of the battle
//        if (attacker.getArmiesAndTheirBrigades().isEmpty()) {
//            return true;
//        }
//
//        defender.setTotalCoalitionCasualties(0);
//        int newTotalCoalitionCasualties = 0;
//
//        Random rng = new Random();
//
//        Set<Unit> attackingArmies = attacker.getArmiesAndTheirBrigades().keySet();
//
//        Iterator<Unit> iterator = defender.getArmiesAndTheirBrigades().keySet().iterator();
//
//        while (iterator.hasNext()) {
//            Unit nextArmy = iterator.next();
//            if (((Army)nextArmy).getBrigades().isEmpty()) {
//                continue;
//            }
//            newTotalCoalitionCasualties += nextArmy.isGettingEngagedBy((Unit) attackingArmies.toArray()[rng.nextInt(attackingArmies.size())]);
//        }
//
//        defender.setTotalCoalitionCasualties(newTotalCoalitionCasualties);
//
//        Set<Unit> updatedArmies = defender.getArmiesAndTheirBrigades().keySet().stream().filter(unit -> ((Army) unit).getBrigades().size() > 0).collect(Collectors.toSet());
//
//        if (updatedArmies.size() > 0) {
//            Map<Unit, List<Unit>> updatedCoalition = new HashMap<>();
//            for (Unit army : updatedArmies) {
//                updatedCoalition.put(army, ((Army) army).getBrigades());
//            }
//            defender.setArmiesAndTheirBrigades(updatedCoalition);
//            return false;
//        } else {
//            return true;
//        }

    }
}
