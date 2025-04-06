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

    @Override
    public int dealDamage (Character character, Attack attack) {
        int index = 0;
        if (attack == null) {
            index += (int) (Math.random() * (2 - 0 +1) + 0 );
            System.out.println("Attack: " + attacks[index].toString());
            character.receiveDamage(attacks[index].baseDamage + strengthBonus);
            return attacks[index].baseDamage + strengthBonus;
        }else {
            character.receiveDamage(attack.baseDamage + strengthBonus);
            return attack.baseDamage + strengthBonus;
        }
    }

    @Override
    public void receiveDamage (int damage) {
        //calc opponent health
            if (this.getArmor() > damage) {
                System.out.println("The damage got blocked");
                this.armor -= damage;
                damage = 0;
            }

        this.health += this.armor;
        this.health -= damage;
        System.out.println("The Enemy has " + this.health + " hp left");
    }

    @Override
    public String toString() {
        return super.toString() +  " Krieger " + " Rüstung: " + this.armor;
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
    @Override
    public int compareTo (Character characters) {
        if (this.armor > ((Warrior) characters).armor) {
            return 1;
        } else if (this.armor < ((Warrior) characters).armor) {
            return -1;
        }
        return 0;
    }
}