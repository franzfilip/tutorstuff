public class Attack {
    protected String attackName;
    protected int baseDamage;
    protected String description;
    protected int manaUsage;

    public Attack(String attackName, int baseDamage, String description, int manaUsage) {
        this.attackName = attackName;
        this.baseDamage = baseDamage;
        this.description = description;
        this.manaUsage = manaUsage;
    }

    public Attack() {
        this.attackName = "unknownAttack";
        this.baseDamage = 1;
        this.description = "unknownDescription";
        this.manaUsage = 0;
    }

    public void setAttackName(String attackName) {
        if (attackName == null || attackName.isBlank()) {
            System.out.println("The attack name cant be empty");
            this.attackName = "unknownAttack";
        }else {
            this.attackName = attackName;
        }
    }

    public void setBaseDamage(int baseDamage) {
        if (baseDamage <= 0) {
            System.out.println("The base damage cant be less than zero");
            this.baseDamage = 1;
        }else {
            this.baseDamage = baseDamage;
        }
    }

    public void setDescription(String description) {
        if (description == null || description.isBlank()) {
            System.out.println("The description cant be empty");
            this.description = "unknownDescription";
        }else {
            this.description = description;
        }
    }

    public void setManaUsage(int manaUsage) {
        if (manaUsage < 0) {
            System.out.println("The mana usage cant be less than zero");
            this.manaUsage = 0;
        }else {
            this.manaUsage = manaUsage;
        }
    }

    public String getAttackName() {
        return this.attackName;
    }

    public int getBaseDamage() {
        return this.baseDamage;
    }

    public String getDescription() {
        return this.description;
    }

    public int getManaUsage() {
        return this.manaUsage;
    }

    public String toString () {
        return "Attacke: " + this.attackName;
    }
}
