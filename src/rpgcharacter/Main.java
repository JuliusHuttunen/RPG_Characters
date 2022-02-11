package rpgcharacter;

public class Main {

    public static void main(String[] args) {
	// write your code here
       Weapon sunBlade = Items.sunBlade;
       Armor chainMail = Items.chainMail;
       Weapon orcAxe = Items.orcAxe;
       Armor steelArmor = Items.steelArmor;

       Warrior shura = new Warrior("Shura");

       Rogue max = new Rogue("Max");

       characterStats(shura);

       shura.equipItem(sunBlade);
       shura.equipItem(chainMail);
       shura.dealDamage();

       characterStats(shura);

       max.levelUp();
       characterStats(max);
       max.levelUp();
       characterStats(max);

       shura.levelUp();
       shura.levelUp();
       shura.equipItem(orcAxe);
       shura.equipItem(steelArmor);
       characterStats(shura);

    }

    public static void characterStats(Character character) {
        if (character.getClass() == Warrior.class) {
            StringBuilder str = new StringBuilder();
            str.append("Name: " + character.name + ", ");
            str.append("Class: " + ((Warrior) character).characterClass + ", ");
            str.append("Level: " + character.level + ", ");
            str.append("STR: " + ((Warrior) character).attributes.strength + ", ");
            str.append("DEX: " + ((Warrior) character).attributes.dexterity + ", ");
            str.append("INT: " + ((Warrior) character).attributes.intelligence + ", ");
            str.append("DPS: " + character.dps);
            System.out.println(str);
        }
        if (character.getClass() == Rogue.class) {
            StringBuilder str = new StringBuilder();
            str.append("Name: " + character.name + ", ");
            str.append("Class: " + ((Rogue) character).characterClass + ", ");
            str.append("Level: " + character.level + ", ");
            str.append("STR: " + ((Rogue) character).attributes.strength + ", ");
            str.append("DEX: " + ((Rogue) character).attributes.dexterity + ", ");
            str.append("INT: " + ((Rogue) character).attributes.intelligence + ", ");
            str.append("DPS: " + character.dps);
            System.out.println(str);
        }
        if (character.getClass() == Ranger.class) {
            StringBuilder str = new StringBuilder();
            str.append("Name: " + character.name + ", ");
            str.append("Class: " + ((Ranger) character).characterClass + ", ");
            str.append("Level: " + character.level + ", ");
            str.append("STR: " + ((Ranger) character).attributes.strength + ", ");
            str.append("DEX: " + ((Ranger) character).attributes.dexterity + ", ");
            str.append("INT: " + ((Ranger) character).attributes.intelligence + ", ");
            str.append("DPS: " + character.dps);
            System.out.println(str);
        }
        if (character.getClass() == Mage.class) {
            StringBuilder str = new StringBuilder();
            str.append("Name: " + character.name + ", ");
            str.append("Class: " + ((Mage) character).characterClass + ", ");
            str.append("Level: " + character.level + ", ");
            str.append("STR: " + ((Mage) character).attributes.strength + ", ");
            str.append("DEX: " + ((Mage) character).attributes.dexterity + ", ");
            str.append("INT: " + ((Mage) character).attributes.intelligence + ", ");
            str.append("DPS: " + character.dps);
            System.out.println(str);
        }
    }

}
