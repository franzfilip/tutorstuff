public abstract class Character {
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

    public int getCharacterId() {
        return this.characterId;
    }

    public String getName() {
        return this.name;
    }

    public int getHealth() {
        return this.health;
    }

    public Attack[] getAttacks() {
        return this.attacks;
    }

    public abstract int dealDamage(Character character, Attack attack);


    public abstract void receiveDamage(int damage);

    public String toString() {
        return "Name: " + this.name + " Leben: " + this.health;
    }

    public int compareTo(Character other) {
            return other.name.compareTo(this.name);
    }

    public boolean searchTerm (String term) {
        return false;
    }

}
