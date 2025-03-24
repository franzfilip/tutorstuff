public class Main {
    public static void main(String[] args) {

    //Attack Array

    //Warrior Attack
    Attack[] warriorAtt = new Attack[3];
    warriorAtt[0] = new Attack("Slash", 20, "Slash your enemy with an sword", 0);
    warriorAtt[1] = new Attack("Pierce", 30, "Pierce through your enemy armor", 0);
    warriorAtt[2] = new Attack("Heavy Strike", 40, "Strike your enemy with your strongest attack", 0);

    //Archer Attack
    Attack[] archerAtt = new Attack[3];
    archerAtt[0] = new Attack("Quik Shot", 10, "Shoot your enemy with an arrow", 0);
    archerAtt[1] = new Attack("Power Shot", 30, "Shoot your enemy with an strong arrow", 0);
    archerAtt[2] = new Attack("Piercing Arrow", 50, "Pierce your enemy with an aimed shoot", 0);

    //Mage Attack
    Attack[] mageAtt = new Attack[3];
    
    }
}