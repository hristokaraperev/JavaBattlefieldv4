package combatants.abstractions;

import weapons.abstractions.Weapon;

public abstract class Human implements Combatant {
    double healthPoints;
    int age;
    double damage;
    String name;
    Weapon weapon;

    public double getDamage() {
        if (weapon.getDurability() > 0) {
            weapon.updateDurability();
            return damage;
        } else {
            return damage * 0.2;
        }
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public void takeDamage(double damage) {
        this.healthPoints -= damage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(double healthPoints) {
        this.healthPoints = healthPoints;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void setAge(int age) {
        this.age = age;
    }


}
