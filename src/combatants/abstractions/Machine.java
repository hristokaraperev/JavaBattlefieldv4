package combatants.abstractions;

public abstract class Machine implements Combatant{
    int durability;
    double damage;
    String name;

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    public double getDamage() {
        if (durability > 0) {
            durability--;
            return damage;
        }
        return 0;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
