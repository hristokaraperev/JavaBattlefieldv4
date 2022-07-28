package factories;

import combatants.abstractions.Combatant;
import combatants.humans.General;
import combatants.humans.Melee;
import combatants.humans.Ranged;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

public class HumanFactory {

    public HumanFactory(){};

    public Combatant createHuman(String type) {
        if (type == null){
            return null;
        }
        WeaponFactory weaponFactory = new WeaponFactory();
        switch (type.toUpperCase()) {
            case "MELEE":
                Melee melee = new Melee();
                melee.setName(setCombatantName());
                melee.setAge(setCombatantAge());
                melee.setHealthPoints(100);
                melee.setWeapon(weaponFactory.createWeapon(type));
                return melee;
            case "RANGED":
                Ranged ranged = new Ranged();
                ranged.setName(setCombatantName());
                ranged.setAge(setCombatantAge());
                ranged.setHealthPoints(100);
                ranged.setWeapon(weaponFactory.createWeapon(type));
                return ranged;
            case "GENERAL":
                General general = new General();
                general.setName(setCombatantName());
                general.setAge(setCombatantAge());
                general.setHealthPoints(100);
                general.setExperience(setGeneralExpirience());
                general.setWeapon(null);
                return general;
            default:
                return null;

        }
    }

    private static int setGeneralExpirience(){
        Random rng = new Random();
        return rng.nextInt(50, 101);
    }

    private static int setCombatantAge(){
        Random rng = new Random();
        return rng.nextInt(18, 40);
    }

    private static String setCombatantName() {
        File file = new File("resources/SoldierNames");
        try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr)){
            StringBuffer sb = new StringBuffer();
            String line;
            while ((line = br.readLine()) !=  null) {
                sb.append(line);
                sb.append(" ");
            }
            StringTokenizer st = new StringTokenizer(sb.toString(), " ");
            List<String> names = new ArrayList<>();
            while (st.hasMoreTokens()) {
                names.add(st.nextToken());
            }
            Random rng = new Random();
            int indexOfName = rng.nextInt(0, names.size());
            return names.get(indexOfName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
