public class Character {
    protected int characterId;
    protected String name;
    protected int health;
    protected Attack[] attacks = new Attack[5];

    public Character(String name, int health, Attack[] attacks) {
        setName(name);
        setHealth(health);
        setAttacks(attacks);
        setCharacterId();

    }
    public Character() {
        this.name = "unknownName";
        this.health = 100;
        this.attacks = null;
        setCharacterId();
    }

    public void setCharacterId() {
        this.characterId = (int) (Math.random() * (10000 - 100 + 1) + 100);
    }

    public void setName(String name) {
        if(name == null|| name.isBlank()) {
            System.out.println("The name cant be empty");
            this.name = "unknownName";
        }else {
            this.name = name;
        }
    }

    public void setHealth(int health) {
        if (health <= 0) {
            System.out.println("The health cant be lower than zero");
            this.health = 100;
        }else {
            this.health = health;
        }
    }

    public void setAttacks(Attack[] attacks) {
        if (this.attacks.length < attacks.length) {
            //resize array
            attacks = new Attack[this.attacks.length];
            for (int i = 0; i < this.attacks.length; i++) {
                this.attacks[i] = attacks[i];
            }
        }else {
            this.attacks = attacks;
        }
    }

    public int dealDamage(Character character, Attack attack) {
        int damageDeal = 0; // damage that is done to the enemy

        //calc Dmg
        damageDeal += attack.baseDamage;
        if (this instanceof Mage) {
            damageDeal += Mage.spellPower;
        }

        character.receiveDamage(damageDeal);
        return damageDeal;
    }

    public void receiveDamage(int damage) {
        int armor = 0;
        //calc opponent health
        if (this instanceof Warrior) {
            armor += ((Warrior) this).getArmor();
            if (((Warrior) this).getArmor() > damage) {
                System.out.println("The damage got blocked");
                armor -= damage;
                damage = 0;
            }
        }

        //Archer
        if (this instanceof Archer) {
            if (((Archer) this).dogdeChance() == 1) { // 25% that 1 is the random number
                System.out.println("The Archer dodged the attack EPIC GAMER MOMENT MLG");
                damage = 0; //because he dodged the attack
            }
        }

        this.health += armor;
        this.health -= damage;
        System.out.println("The Enemy has " + this.health + " hp");
    }
}
