public class Archer extends Character {

    public Archer(String name, int health, Attack[] attacks) {
        super(name, health, attacks);
    }
    public int dogdeChance () {
        return (int) (Math.random() * (4 - 1 + 1) + 1 );
    }
}
