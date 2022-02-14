package rpgcharacter;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws NoSuchFieldException {

        //-----------------COMMAND LINE 'GAME'--------------------//

        /* PrintStream printer = System.out;
        Scanner input = new Scanner(System.in);
        boolean stop = false;
        Character currentHero = null;

        printer.print("Name your hero: ");
        String chosenName = input.nextLine();
        printer.println("Pick a character class for your hero:");
        printer.println("1. Mage");
        printer.println("2. Ranger");
        printer.println("3. Rogue");
        printer.println("4. Warrior");
        printer.print("Make your choice: ");
        int chosenClass = input.nextInt();
        input.nextLine();

        if(chosenClass == 1){
            Mage mage = new Mage(chosenName);
            currentHero = mage;
        }
        if(chosenClass == 2){
            Ranger ranger = new Ranger(chosenName);
            currentHero = ranger;
        }
        if(chosenClass == 3){
            Rogue rogue = new Rogue(chosenName);
            currentHero = rogue;
        }
        if(chosenClass == 4){
            Warrior warrior = new Warrior(chosenName);
            currentHero = warrior;
        }

        characterStats(currentHero);

        printer.println("Choose an action:");
        printer.println("1. Level up");
        printer.println("2. Show stats");
        printer.println("3. Deal damage to an enemy");
        printer.println("4. Equip items");
        printer.println("5. Terminate program");

        while(!stop) {
            printer.print("Make your choice: ");
            int chosenMethod = input.nextInt();
            input.nextLine();

            if (chosenMethod == 1) {
                currentHero.levelUp();
            }
            if (chosenMethod == 2) {
                characterStats(currentHero);
            }
            if (chosenMethod == 3) {
                currentHero.dealDamage();
            }
            if (chosenMethod == 4) {
                printer.print("Input the item name: ");
                String item = input.nextLine();
                currentHero.equipItem(Items.getItem(item));
            }
            if (chosenMethod == 5) {
                printer.println("Terminating...");
                stop = true;
            }
        }

        */

        //------------------DEMONSTRATION---------------//

        //Create character
        Warrior conan = new Warrior("Conan");
        characterStats(conan);

        //Deal damage (dps)
        conan.dealDamage();

        //Level up twice
        conan.levelUp();
        characterStats(conan);
        conan.levelUp();
        characterStats(conan);

        //Equip armor
        conan.equipItem(Items.getItem("Steel Armor"));
        characterStats(conan);

        //Equip weapon
        conan.equipItem(Items.getItem("Orcish Axe"));
        characterStats(conan);

        //Equip lesser armor
        conan.equipItem(Items.getItem("Chainmail"));
        characterStats(conan);

        //Level up
        conan.levelUp();
        characterStats(conan);

    }

    public static void characterStats(Character character) {
        StringBuilder str = new StringBuilder();
        str.append("Name: " + character.name + ", ");
        str.append("Class: " + character.characterClass + ", ");
        str.append("Level: " + character.level + ", ");
        str.append("STR: " + character.attributes.strength + ", ");
        str.append("DEX: " + character.attributes.dexterity + ", ");
        str.append("INT: " + character.attributes.intelligence + ", ");
        str.append("DPS: " + character.dps);
        System.out.println(str);
    }
}
