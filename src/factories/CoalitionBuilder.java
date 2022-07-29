package factories;

import combatants.abstractions.Combatant;
import composite.Army;
import composite.Brigade;
import composite.abstractions.Unit;

import java.util.*;

public class CoalitionBuilder {

    private static final int ARMIES_PER_COALITION = 5;
    private static final int BRIGADES_PER_ARMY = 10;
    private static final int SOLDIERS_PER_BRIGADE = 100;

    public CoalitionBuilder(){};

    public List<Unit> createCoalition() {
        HumanFactory humanFactory = new HumanFactory();
        MachineFactory machineFactory = new MachineFactory();
        List<Unit> armies = new ArrayList<>();
        String[] humanTypes = {"MELEE", "RANGED"};
        String[] machineTypes = {"LAND", "AIR"};
        Random rng = new Random();
        for (int i = 0; i < ARMIES_PER_COALITION; i++) {
            Army army = new Army();
            List<Unit> brigades = new ArrayList<>();
            for (int j = 0; j < BRIGADES_PER_ARMY; j++) {
                Brigade brigade = new Brigade();
                brigade.setWarMachine(machineFactory.createMachine(machineTypes[rng.nextInt(machineTypes.length)]));
                List<Combatant> soldiers = new ArrayList<>();
                for (int k = 0; k < SOLDIERS_PER_BRIGADE; k++) {
                    Combatant soldier = humanFactory.createHuman(humanTypes[rng.nextInt(humanTypes.length)]);
                    soldiers.add(soldier);
                }
                brigade.setHumans(soldiers);
                brigades.add(brigade);
            }
            army.setBrigades(brigades);
            army.setGeneral(humanFactory.createHuman("GENERAL"));
            army.setInitialArmyCapacity(BRIGADES_PER_ARMY * SOLDIERS_PER_BRIGADE);
            armies.add(army);
        }
        return armies;


    }

}
