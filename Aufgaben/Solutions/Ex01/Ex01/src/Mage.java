public class Mage extends Character {
    protected int mana;
    protected static final int spellPower = 10;

    public Mage(String name, int health, Attack[] attacks, int mana) {
        super(name, health, attacks);
        setMana(mana);
    }

    public Mage() {
        this.mana = 100;
    }

    public void setMana(int mana) {
        if (mana <= 0) {
            System.out.println("The mana cant be less than zero");
            this.mana = 100;
        }else {
            this.mana = mana;
        }
    }

    public int getMana() {
        return this.mana;
    }
}
