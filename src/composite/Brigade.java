package composite;

import combatants.abstractions.Combatant;
import combatants.abstractions.Human;
import combatants.abstractions.Machine;
import composite.abstractions.Unit;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Brigade extends Unit {
    // building block of the army
    // it will define the behaviour of the elements in the composition
    private Machine warMachine;
    private List<Combatant> humans;


    @Override
    public int isGettingEngagedBy(Unit unit, Combatant defendingArmyGeneral) {
        if (((Brigade) unit).getHumans().isEmpty() || humans.isEmpty()) {
            return 0;
        }
        Random rng = new Random();

        humans.get(rng.nextInt(humans.size())).isFighting(((Brigade) unit).warMachine);

        List<Combatant> attackingHumans = ((Brigade) unit).getHumans();

        Iterator<Combatant> defendingHumansIterator = humans.iterator();

        while (defendingHumansIterator.hasNext()) {
            Combatant nextCombatant = defendingHumansIterator.next();
            if (!(((Human) nextCombatant).getHealthPoints() > 0)) {
                continue;
            }
            int indexOfAttackingHuman = rng.nextInt(attackingHumans.size());

            if (rng.nextInt(101) < 1) {
                defendingArmyGeneral.isFighting(attackingHumans.get(indexOfAttackingHuman));
                if (((Human) defendingArmyGeneral).getHealthPoints() <= 0) {
                    return 0;
                }
                continue;
            }

            nextCombatant.isFighting(attackingHumans.get(indexOfAttackingHuman));
        }


        List<Combatant> updatedDefendingHumans = humans.stream().filter(combatant -> ((Human) combatant).getHealthPoints() > 0).toList();

        int defendingCasualties = humans.size() - updatedDefendingHumans.size();

        humans = updatedDefendingHumans;

        return defendingCasualties;
    }


    public List<Combatant> getHumans() {
        return humans;
    }

    public void setHumans(List<Combatant> humans) {
        this.humans = humans;
    }

    public void setWarMachine(Machine warMachine) {
        this.warMachine = warMachine;
    }

    public Machine getWarMachine() {
        return warMachine;
    }
}
