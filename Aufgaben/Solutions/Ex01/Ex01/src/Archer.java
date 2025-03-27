public class Archer extends Character {

    public Archer(String name, int health, Attack[] attacks) {
        super(name, health, attacks);
    }
    public int dogdeChance () {
        return (int) (Math.random() * (4 - 1 + 1) + 1 );
    }

    @Override
    public int dealDamage (Character character, Attack attack) {
        int index = 0;
        if (attack == null) {
            index += (int) (Math.random() * (2 - 0 +1) + 0 );
            character.receiveDamage(attacks[index].baseDamage);
            return attacks[index].baseDamage;
        }else {
            character.receiveDamage(attack.baseDamage);
            return attack.baseDamage;
        }
    }

    @Override
    public void receiveDamage (int damage) {
        //Archer
            if (dogdeChance() == 1) { // 25% that 1 is the random number
                System.out.println("The Archer dodged the attack EPIC GAMER MOMENT MLG");
                damage = 0; //because he dodged the attack
            }

        this.health -= damage;
        System.out.println("The Enemy has " + this.health + " hp left");
    }

    @Override
    public String toString() {
        return super.toString() + " Bogenschütze" + " da ist noch nix" ;
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
