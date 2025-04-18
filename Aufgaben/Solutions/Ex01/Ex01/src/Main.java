public class Main {
    public static void main(String[] args) {
    //Attack Array

    //Warrior Attack
    Attack[] warriorAtt = new Attack[3];
    warriorAtt[0] = new Attack("Slash", 20, "Slash your enemy with an sword", 0);
    warriorAtt[1] = new Attack("Pierce", 30, "Pierce through your enemy armor", 0);
    warriorAtt[2] = new Attack("Heavy Strike", 40, "Strike your enemy with an critical hit", 0);

    //Archer Attack
    Attack[] archerAtt = new Attack[3];
    archerAtt[0] = new Attack("Quik Shot", 10, "Shoot your enemy with an arrow", 0);
    archerAtt[1] = new Attack("Power Shot", 30, "Shoot your enemy with an strong arrow", 0);
    archerAtt[2] = new Attack("Piercing Arrow", 50, "Pierce your enemy with an ritical shoot", 0);

    //Mage Attack
    Attack[] mageAtt = new Attack[3];
    mageAtt[0] = new Attack("Magic Bolt", 30, "Strike your enemy with an energie bolt", 20);
    mageAtt[1] = new Attack("Fire", 20, "Burn your enemys to the ground", 15);
    mageAtt[2] = new Attack("Doomsday", 70, "Critical damage your enemy in an Area attack", 80);

        //Create Charactars
        Character[] characters = new Character[20];

        characters[0] = new Warrior("Ralp", 150, warriorAtt, 50);
        characters[5] = new Archer("Bob", 70, archerAtt);
        characters[10] = new Mage("Jim", 60, mageAtt, 150);
        characters[11] = new Warrior("Tim", 130, warriorAtt, 20);
        characters[17] = new Archer("Tom", 80, archerAtt);
        characters[7] = new Mage("Subaru", 100, mageAtt, 300); //OP

        //3 Arrays


        //Ausgabe unsotiert
        System.out.println("Unsotiert");
        printArr(characters);


        System.out.println("Sortiert");
        moveNull(characters);
        Character[] sorted = sortArr(characters);
        printArr(sorted);
        characters = sorted;
        System.out.println("----------------------------");

        printArr(characters);

        //search
        System.out.println("Search");
        search(characters);

        //Fight
        fight(characters);
    }
    public static void printArr (Character[] character) {
        for (int i = 0; i < character.length; i++) {
            if (character[i] != null) {
                System.out.println(character[i].toString());
            }
        }
    }
    public static Character[] sortArr (Character[] characters) {
        Character[] war = new Character[20];
        Character[] arc = new Character[20];
        Character[] mag = new Character[20];
        sortIntoThree(characters, war, arc, mag);

        sortByProperty(war);
        sortByProperty(arc);
        sortByProperty(mag);

        Character[] result = new Character[20];
        fillArr(result, war);
        fillArr(result, arc);
        fillArr(result, mag);

        return result;

    }

    public static void fillArr (Character[] characters, Character[] copy) {
        for (int i = 0; i < copy.length; i++) {
            characters[getNextIndex(characters)] = copy[i];
        }
    }

    public static int getNextIndex (Character[] characters) {
        for (int i = 0; i < characters.length; i++) {
            if (characters[i] == null) {
                return i;
            }
        }
        return 0;
    }

    public static void sortByProperty (Character[] characters) {
        for (int i = 0; i < characters.length; i++) {
            for (int j = 0; j < characters.length-1; j++) {
                if (characters[j] != null && characters[j + 1] != null) {
                    if (characters[j].compareTo(characters[j + 1]) > 1) {
                        Character temp = characters[j];
                        characters[j] = characters[j+1];
                        characters[j+1] = temp;
                    }
                }
            }
        }
    }

    public static void moveNull (Character[] characters) {
        int index = 0;
        for (int i = 0; i < characters.length; i++) {
            if (characters[i] != null) {
                characters[index++] = characters[i];
            }
        }
        while (index < characters.length) {
            characters[index++] = null;
        }
    }

    public static void search (Character[] characters) {
        String term = "critical";

        for (int i = 0; i < characters.length; i++) {
            if (characters[i] != null) {
                if (characters[i].searchTerm(term)) {
                    System.out.println("ID: " + characters[i].getCharacterId() + " Name: " + characters[i].getName());
                }
            }
        }
    }

    public static void fight (Character[] arr) {
        int fighter1 = 0;
        int fighter2 = 0;

        while (fighter1 == fighter2) {
            fighter1 = (int) (Math.random() * (5 - 0 +1) + 0 );
            fighter2 = (int) (Math.random() * (5 - 0 +1) + 0 );
        }
        System.out.println(arr[fighter1].toString() + " vs " + arr[fighter2].toString());
        while (arr[fighter1].getHealth() >= 0 && arr[fighter2].getHealth() >= 0) {
            arr[fighter1].dealDamage(arr[fighter2], null);
            arr[fighter2].dealDamage(arr[fighter1], null);
        }
        if (arr[fighter1].getHealth() > 0) {
            System.out.println(arr[fighter1].name + " hat gewonnen");
        }else {
            System.out.println(arr[fighter2].name + " hat gewonnen");
        }
    }
    public static void sortIntoThree (Character[] arr, Character[] war, Character[] arc, Character[] mag) {
        int indexWar = 0;
        int indexArc = 0;
        int indexMag = 0;

        for (int i = 0;  i < arr.length; i++) {
            if (arr[i] instanceof Warrior) {
                war[indexWar] = arr[i];
                indexWar++;
            } else if (arr[i] instanceof Archer) {
                arc[indexArc] = arr[i];
                indexArc++;
            } else if (arr[i] instanceof  Mage) {
                mag[indexMag] = arr[i];
                indexMag++;
            }
        }
    }
}