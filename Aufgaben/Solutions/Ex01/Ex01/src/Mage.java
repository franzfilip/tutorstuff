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

    @Override
    public int dealDamage (Character character, Attack attack) {
        int index = 0;
        if (attack == null) {
            index += (int) (Math.random() * (2 - 0 + 1) + 0);

            this.mana -= attacks[index].manaUsage;

            if (this.mana > attacks[index].manaUsage) {
                character.receiveDamage(attacks[index].baseDamage + spellPower);
            } else {
                System.out.println("Du hast kein Mana mehr");
                character.receiveDamage(0);
                return 0;
            }
            return attacks[index].baseDamage + spellPower;
        } else {
            this.mana -= attack.manaUsage;

            if (this.mana > attack.manaUsage) {
                character.receiveDamage(attack.baseDamage + spellPower);
            } else {
                System.out.println("Du hast kein Mana mehr");
                character.receiveDamage(0);
                return 0;
            }
            return attack.baseDamage + spellPower;
        }
    }

    @Override
    public void receiveDamage (int damage) {
        this.health -= damage;
        System.out.println("The Enemy has " + this.health + " hp left");
    }
    public String toString() {
        return super.toString() + " Magier " + " Mana: " + this.mana;
    }

    @Override
    public boolean searchTerm (String term) {
        for (int i = 0; i < this.attacks.length; i++) {
            if (this.attacks[i].description.toLowerCase().contains(term)) {
                return true;
            }
        }
        return false;
    }
}
