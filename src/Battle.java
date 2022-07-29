import combatants.humans.General;
import composite.Army;
import composite.Coalition;
import visitor.BattleLine;

public class Battle implements Runnable {
    @Override
    public void run() {
        Coalition good = new Coalition();
        Coalition bad = new Coalition();

        int goodExperience = good.getArmies().stream().mapToInt(value -> ((Army) value).getGeneralExperience()).sum();
        int badExperience = bad.getArmies().stream().mapToInt(value -> ((Army) value).getGeneralExperience()).sum();

        BattleLine battleLine = new BattleLine();

        if (goodExperience > badExperience) {
            battle(good, bad, battleLine);
        } else {
            battle(bad, good, battleLine);
        }

    }

    private void battle(Coalition attacker, Coalition defender, BattleLine battleLine) {

        while (true) {
            if (battleLine.visit(attacker, defender)) break;
            if (battleLine.visit(defender, attacker)) break;

        }


        if (attacker.getArmies().size() == 0 || attacker.getArmies().stream().anyMatch(unit -> ((General) ((Army) unit).getGeneral()).getHealthPoints() <= 0)) {
            System.out.println("WINNER");
            System.out.println(defender);
            System.out.println("LOSER");
            if (attacker.getArmies().size() == 0) {
                System.out.println("ARMY WAS DESTROYED");
            } else {
                System.out.println(attacker);
            }
        } else {
            System.out.println("WINNER");
            System.out.println(attacker);
            System.out.println("LOSER");
            if (defender.getArmies().size() == 0) {
                System.out.println("ARMY WAS DESTROYED");
            } else {
                System.out.println(defender);
            }
        }

        System.out.println();
        System.out.println("FINISH");

    }
}
