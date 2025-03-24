public class Warrior extends Character {
    protected int armor;
    protected static final int strengthBonus = 10;

    public Warrior(String name, int health, Attack[] attacks, int armor) {
        super(name, health, attacks);
        setArmor(armor);
    }

    public Warrior() {
        this.armor = 30;
    }

    public void setArmor(int armor) {
        if (armor <= 0) {
            this.armor = 30;
        }else {
            this.armor = armor;
        }
    }

    public int getArmor() {
        return this.armor;
    }
}