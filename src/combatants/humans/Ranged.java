package combatants.humans;

import combatants.abstractions.Combatant;
import combatants.abstractions.Human;
import combatants.abstractions.Machine;

public class Ranged extends Human {
    @Override
    public void isFighting(Combatant attacker) {
        if (attacker.getClass().getSuperclass() == Machine.class) {
            this.takeDamage(((Machine) attacker).getDamage());
        } else {
            this.takeDamage(((Human) attacker).getDamage());
        }
    }
}
