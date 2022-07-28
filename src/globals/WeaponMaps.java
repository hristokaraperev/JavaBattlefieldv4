package globals;

import java.util.HashMap;
import java.util.Map;

public class WeaponMaps {
    public final Map<String, Integer> weaponDamageValues = new HashMap<>();
    public final Map<String, Integer> weaponDurabilityValues = new HashMap<>();


    public WeaponMaps(){
        weaponDamageValues.put("Knife", 15);
        weaponDamageValues.put("Baton", 10);
        weaponDamageValues.put("Axe", 25);
        weaponDamageValues.put("Rifle", 20);
        weaponDamageValues.put("Handgun", 10);
        weaponDamageValues.put("Flamethrower", 5);
        weaponDamageValues.put("Sniper", 25);
        weaponDamageValues.put("LAND", 50);
        weaponDamageValues.put("AIR", 50);

        weaponDurabilityValues.put("Knife", 15);
        weaponDurabilityValues.put("Baton", 20);
        weaponDurabilityValues.put("Axe", 10);
        weaponDurabilityValues.put("Rifle", 20);
        weaponDurabilityValues.put("Handgun", 15);
        weaponDurabilityValues.put("Flamethrower", 15);
        weaponDurabilityValues.put("Sniper", 20);
        weaponDurabilityValues.put("LAND", 10);
        weaponDurabilityValues.put("AIR", 10);
    }
}
