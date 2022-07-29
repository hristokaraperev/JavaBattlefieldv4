package composite;

import combatants.abstractions.Combatant;
import combatants.abstractions.Human;
import combatants.abstractions.Machine;
import combatants.humans.General;
import composite.abstractions.Unit;
import utils.*;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Army extends Unit {
    private int initialArmyCapacity = 0;
    private int currentArmySize = 0;
    private int defendingBrigadesCasualties = 0;
    private int totalArmyCasualties = 0;
    private Combatant general;
    private List<Unit> brigades;
    private List<Machine> machines;
    private double armyMorale = 1;

    @Override
    public int isGettingEngagedBy(Unit attackerArmy, Combatant defendingArmyGeneral) {
        if (((Army) attackerArmy).getBrigades().isEmpty() || brigades.isEmpty()) {
            return 0;
        }

        if ((((Human) ((Army) attackerArmy).getGeneral()).getHealthPoints() <= 0) || ((Human) defendingArmyGeneral).getHealthPoints() <= 0) {
            return 0;
        }


        Random rng = new Random();

        List<Unit> attackingBrigades = ((Army) attackerArmy).getBrigades();

        Iterator<Unit> defendingBrigadesIterator = brigades.iterator();

        while (defendingBrigadesIterator.hasNext()) {
            Unit nextBrigade = defendingBrigadesIterator.next();
            if (((Brigade) nextBrigade).getHumans().isEmpty()) {
                continue;
            }
            int indexOfAttackingBrigade = rng.nextInt(attackingBrigades.size());

            defendingBrigadesCasualties += nextBrigade.isGettingEngagedBy(attackingBrigades.get(indexOfAttackingBrigade), defendingArmyGeneral);
            if (((Human) defendingArmyGeneral).getHealthPoints() <= 0) {
                return 0;
            }
        }

        List<Unit> updatedDefendingBrigades = brigades.stream().filter(unit -> !((Brigade) unit).getHumans().isEmpty()).toList();

        totalArmyCasualties += defendingBrigadesCasualties;

        currentArmySize = 0;

        for (Unit brigade : updatedDefendingBrigades) {
            currentArmySize += ((Brigade) brigade).getHumans().size();
        }

        if ((initialArmyCapacity - currentArmySize) > (initialArmyCapacity * 0.2)) {
            if (rng.nextInt(101) < 50) {
                armyMorale = armyMorale * 2;
            }
        }

        if (totalArmyCasualties != 0) {
            int moraleModifier = totalArmyCasualties / 50;
            armyMorale = armyMorale - (armyMorale * moraleModifier * 0.01);
            for (Unit brigade : this.getBrigades()) {
                ((Brigade)brigade).getHumans().forEach(combatant -> ((Human)combatant).updateDamage(armyMorale));
            }
            defendingBrigadesCasualties = 0;
        }

        brigades = updatedDefendingBrigades;

        return totalArmyCasualties;
    }

    public List<Machine> getMachines() {
        return machines;
    }

    public void setMachines(List<Machine> machines) {
        this.machines = machines;
    }

    public List<Unit> getBrigades() {
        return brigades;
    }

    public void setBrigades(List<Unit> brigades) {
        this.brigades = brigades;
    }

    public Combatant getGeneral() {
        return general;
    }

    public void setGeneral(Combatant general) {
        this.general = general;
    }

    public void setInitialArmyCapacity(int initialArmyCapacity) {
        this.initialArmyCapacity = initialArmyCapacity;
    }

    public int getGeneralExperience() {
        return ((General) general).getExperience();
    }


    @Override
    public String toString() {
        String format = "0.00";
        NumberFormat formatter = new DecimalFormat(format);
        String healthPoints = formatter.format(((Human) general).getHealthPoints());
        return "Army - General: " + ((Human) general).getName() + " HP: " + healthPoints + " Soldiers left: " + currentArmySize;
    }

    public void printAllArmyWeapons() {
        System.out.println("GENERAL");
        System.out.println(general);
        for (Unit brigade : brigades) {
            System.out.println("BRIGADE");
            for (Combatant combatant : ((Brigade) brigade).getHumans()) {
                System.out.println(combatant);
            }
            System.out.println(((Brigade)brigade).getWarMachine());
        }
    }
}
