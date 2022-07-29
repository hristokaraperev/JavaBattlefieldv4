package factories;

import combatants.abstractions.Combatant;
import combatants.abstractions.Machine;
import combatants.machines.AirMachine;
import combatants.machines.LandMachine;
import globals.WeaponMaps;

public class MachineFactory {

    public MachineFactory(){};

    public Combatant createMachine(String type) {
        if (type == null){
            return null;
        }
        WeaponMaps weaponMaps = new WeaponMaps();
        switch (type.toUpperCase()) {
            case "LAND":
                Machine landMachine = new LandMachine();
                landMachine.setName(type);
                landMachine.setDamage(weaponMaps.weaponDamageValues.get(type));
                landMachine.setDurability(weaponMaps.weaponDurabilityValues.get(type));
                return landMachine;
            case "AIR":
                Machine airMachine = new AirMachine();
                airMachine.setName(type);
                airMachine.setDamage(weaponMaps.weaponDamageValues.get(type));
                airMachine.setDurability(weaponMaps.weaponDurabilityValues.get(type));
                return airMachine;
            default:
                return null;

        }
    }
}
